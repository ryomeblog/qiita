package com.example.tmpSpringBoot.dao;

import java.util.*;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.*;

import com.example.tmpSpringBoot.dao.generator.*;
import com.example.tmpSpringBoot.dto.generator.*;

/**
 * 「user_mst」テーブル用DAO
 */

@Repository
public interface UserMstMapperImpl extends UserMstMapper {

    /**
     * ユーザIDをキーにユーザ情報を取得します。
     *
     * @param userId ユーザID
     * @return ユーザ情報
     */
    UserMst selectByUserId(@Param("userId") String userId);

    /**
     * 最大のユーザIDを取得します。
     *
     * @return ユーザID
     */
    String selectMaxUserId();

    /**
     * ユーザ件数を取得します。
     *
     * @param userId ユーザID
     * @param userName ユーザ名
     * @param authority 権限
     * @return ユーザ情報
     */
    Integer selectUserListCount(
            @Param("userId") String userId,
            @Param("userName") String userName,
            @Param("authority") Byte authority);

    /**
     * ユーザ情報を取得します。
     *
     * @param userId ユーザID
     * @param userName ユーザ名
     * @param authority 権限
     * @param orderBy ソート項目
     * @param ascOrDesc 昇順／降順
     * @param limit 最大取得数
     * @param offset オフセット
     * @return ユーザ情報
     */
    List<UserMst> selectUserList(
            @Param("userId") String userId,
            @Param("userName") String userName,
            @Param("authority") Byte authority,
            @Param("orderBy") Integer orderBy,
            @Param("ascOrDesc") Integer ascOrDesc,
            @Param("limit") Integer limit,
            @Param("offset") Integer offset);

    /**
     * ユーザ情報を更新します。
     *
     * @param User 更新ユーザ情報
     * @return 更新件数
     */
    Integer updateUser(UserMst User);

    /**
     * ユーザのパスワードを更新します。
     *
     * @param User 更新ユーザ情報
     * @return 更新件数
     */
    Integer updatePassword(UserMst User);

    /**
     * ユーザ情報を更新します。
     *
     * @param userId ユーザID
     * @return 削除判定
     */
    Boolean deleteUser(@Param("userId") String userId);
}
