package com.example.tmpSpringBoot.service.account;

import static com.example.tmpSpringBoot.common.CommonUtils.*;
import static com.example.tmpSpringBoot.common.Functions.*;
import static com.example.tmpSpringBoot.constant.Constant.*;
import static com.example.tmpSpringBoot.constant.IdFormatterConstant.*;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;

import com.example.tmpSpringBoot.constant.*;
import com.example.tmpSpringBoot.dao.*;
import com.example.tmpSpringBoot.dto.generator.*;
import com.example.tmpSpringBoot.exception.*;

/**
 * ユーザ管理機能 サービス
 */
@Service
public class AccountServiceImpl implements AccountService {

    /** ユーザテーブルMapperImpl */
    @Autowired
    private UserMstMapperImpl userMstMapper;

    /** 汎用マスタテーブルMapperImpl */
    @Autowired
    private CommonMstMapperImpl commonMstMapperImpl;

    /**
     * ユーザ件数を取得し、返却します。
     *
     * @param userId ユーザID
     * @param userName ユーザ名
     * @param authority 権限
     * @param limit 最大取得数
     * @param offset オフセット
     * @return ユーザ件数
     */
    @Override
    public Integer getUserListCount(String userId, String userName, Byte authority) {
        return userMstMapper.selectUserListCount(userId, userName, authority);
    }

    /**
     * ユーザ情報を取得し、返却します。
     *
     * @param userId ユーザID
     * @param userName ユーザ名
     * @param authority 権限
     * @param orderBy ソート項目
     * @param ascOrDesc 昇順／降順
     * @param limit 最大取得数
     * @param offset オフセット
     * @return ユーザ情報リスト
     */
    @Override
    public List<UserMst> getUserList(
            String userId,
            String userName,
            Byte authority,
            Integer orderBy,
            Integer ascOrDesc,
            Integer limit,
            Integer offset) {
        return userMstMapper.selectUserList(userId, userName, authority, orderBy, ascOrDesc, limit, offset);
    }

    /**
     * ユーザIDをキーにユーザ情報を取得し、返却します。
     *
     * @return ユーザ情報
     */
    @Override
    public UserMst getUserListByUserId() {
        return userMstMapper.selectByUserId(getLoginUserId());
    }

    /**
     * 秘密の質問情報を取得し、返却します。
     *
     * @return 秘密の質問リスト
     */
    @Override
    public List<CommonMst> getQuestion() {
        return commonMstMapperImpl.selectByGroup(COM_GROUP_01);
    }

    /**
     * アカウント作成処理を行います。
     *
     * @param userMst ユーザ情報
     * @return maxUserId 最大ユーザID
     */
    @Override
    public String insertUser(UserMst userMst) {

        // 秘密の質問存在チェック
        secretIdCheck(userMst.getSecretId());

        // 最大値ユーザIDを取得
        String userId = userMstMapper.selectMaxUserId();

        // 最大値ユーザID + 1
        String maxUserId = format(idToValue(userId, USER_ID_PREFIX) + 1, USER_ID_FORMAT);

        // ユーザID作成確認
        if (isNull(maxUserId)) {
            throw new TmpSpringBootRuntimeException(HttpStatus.INTERNAL_SERVER_ERROR, ResultCode.C104);
        }

        // 最大のユーザIDを格納
        userMst.setUserId(maxUserId);

        // アカウント追加処理
        userMstMapper.insertSelective(userMst);

        return maxUserId;
    }

    /**
     * アカウント編集処理を行います。
     *
     * @param userMst ユーザ情報
     */
    @Override
    public void editUser(UserMst userMst) {

        // ユーザ取得
        UserMst getUserMst = userMstMapper.selectByUserId(userMst.getUserId());

        if (isNull(getUserMst)) {
            // ユーザが存在しない
            throw new TmpSpringBootRuntimeException(HttpStatus.NOT_FOUND, ResultCode.C105);
        }

        // 秘密の質問存在チェック
        secretIdCheck(nvl(userMst.getSecretId(), getUserMst.getSecretId()));

        if (!eq(getUserMst.getVersion(), userMst.getVersion())) {
            // バージョン不一致による排他制御
            throw new TmpSpringBootRuntimeException(HttpStatus.CONFLICT, ResultCode.C107);
        }

        if (userMstMapper.updateUser(userMst) == 0) {
            // 不正なDB処理
            throw new TmpSpringBootRuntimeException(HttpStatus.INTERNAL_SERVER_ERROR, ResultCode.C109);
        }
    }

    /**
     * アカウントの秘密の質問と答えが同じユーザのパスワードを変更します。
     *
     * @param userMst ユーザ情報
     */
    @Override
    public void editQuestion(UserMst userMst) {

        // 秘密の質問存在チェック
        secretIdCheck(userMst.getSecretId());

        // ユーザ取得
        UserMst getUserMst = userMstMapper.selectByUserId(userMst.getUserId());

        if (isNull(getUserMst)) {
            // ユーザが存在しない
            throw new TmpSpringBootRuntimeException(HttpStatus.NOT_FOUND, ResultCode.C105);
        }

        // アカウントロックチェック
        if (getUserMst.getLock()) { throw new TmpSpringBootRuntimeException(HttpStatus.FORBIDDEN, ResultCode.C103); }

        if (!eq(userMst.getSecretId(), getUserMst.getSecretId())
                || !passwordMatches(userMst.getSecretAnswer(), getUserMst.getSecretAnswer())) {
            // 秘密の質問と答えが一致しない
            throw new TmpSpringBootRuntimeException(HttpStatus.NOT_FOUND, ResultCode.C105);
        }

        // バージョン情報を格納
        userMst.setVersion(getUserMst.getVersion());

        if (userMstMapper.updatePassword(userMst) == 0) {
            // 不正なDB処理
            throw new TmpSpringBootRuntimeException(HttpStatus.INTERNAL_SERVER_ERROR, ResultCode.C109);
        }
    }

    /**
     * アカウント削除処理を行います。
     */
    @Override
    public void deleteUser() {

        // ユーザID取得
        String userId = getLoginUserId();

        // ユーザ情報取得
        UserMst userMst = userMstMapper.selectByUserId(userId);

        // ユーザの存在チェック
        if (isNull(userMst)) {
            // ユーザが存在しない
            throw new TmpSpringBootRuntimeException(HttpStatus.NOT_FOUND, ResultCode.C105);
        }

        // 削除処理
        if (!userMstMapper.deleteUser(userId)) {
            // 不正なSQL文の検知
            throw new TmpSpringBootRuntimeException(HttpStatus.INTERNAL_SERVER_ERROR, ResultCode.C109);
        }
    }

    /**
     * 秘密の質問IDが存在するか確認を行います。
     *
     * @param secretId 秘密の質問ID
     */
    private void secretIdCheck(String secretId) {
        // 食材単位レコード存在確認
        if (isNotNull(secretId)) {
            // レコード存在確認
            if (isNull(commonMstMapperImpl.selectByPrimaryKey(secretId))) {
                throw new TmpSpringBootRuntimeException(HttpStatus.NOT_FOUND, ResultCode.C105);
            }
        }
    }

}
