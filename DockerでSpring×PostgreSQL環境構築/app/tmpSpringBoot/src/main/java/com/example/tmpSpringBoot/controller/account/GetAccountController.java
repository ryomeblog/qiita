package com.example.tmpSpringBoot.controller.account;

import static com.example.tmpSpringBoot.common.CommonUtils.*;
import static com.example.tmpSpringBoot.common.Functions.*;

import java.util.*;
import java.util.stream.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.validation.*;
import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.*;

import com.example.tmpSpringBoot.constant.*;
import com.example.tmpSpringBoot.controller.*;
import com.example.tmpSpringBoot.dto.generator.*;
import com.example.tmpSpringBoot.request.account.*;
import com.example.tmpSpringBoot.response.*;
import com.example.tmpSpringBoot.response.account.*;
import com.example.tmpSpringBoot.service.account.*;

/**
 * API003 - ユーザ検索機能 コントローラ
 */
@RestController
public class GetAccountController extends BaseController {

    /** アカウントサービス */
    @Autowired
    private AccountService accountService;

    @GetMapping(ApiUri.SEARCH)
    public ApiResponseOptional<GetAccountResponse> getAccount(
            @ModelAttribute @Validated GetAccountRequest request, BindingResult bindingResult) {
        // バリデーションチェック
        valid(bindingResult);

        // ユーザ総件数
        Integer total = asInt(accountService.getUserListCount(
                request.getUserId(),
                request.getUserName(),
                toByte(request.getAuthority())));

        // ユーザリスト
        List<UserMst> dtoList = accountService.getUserList(
                request.getUserId(),
                request.getUserName(),
                toByte(request.getAuthority()),
                toInt(request.getOrderBy()),
                toInt(request.getAscOrDesc()),
                toInt(request.getLimit()),
                toInt(request.getOffset()));

        // レスポンス返却
        return new ApiResponseOptional<>(ResultCode.C000, createResponse(total, dtoList));
    }

    GetAccountResponse createResponse(Integer total, List<UserMst> dtoList) {
        // レスポンス作成
        GetAccountResponse optional = new GetAccountResponse();

        // レスポンス格納
        optional.setTotal(total);
        optional.setUserList(dtoList.stream().map(
                dto -> new GetAccountResponse.User()
                        .setUserId(dto.getUserId())
                        .setUserName(dto.getUserName())
                        .setAuthority(getRole(dto.getAuthority()))
                        .setVersion(dto.getVersion()))
                .collect(Collectors.toList()));

        return optional;
    }

}
