package com.example.tmpSpringBoot.controller.account;

import static com.example.tmpSpringBoot.common.CommonUtils.*;
import static com.example.tmpSpringBoot.common.Functions.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import com.example.tmpSpringBoot.constant.*;
import com.example.tmpSpringBoot.controller.*;
import com.example.tmpSpringBoot.dto.generator.*;
import com.example.tmpSpringBoot.response.*;
import com.example.tmpSpringBoot.response.account.*;
import com.example.tmpSpringBoot.service.account.*;

/**
 * API004 - ユーザ詳細検索機能 コントローラ
 */
@RestController
public class GetAccountByUserIdController extends BaseController {

    /** アカウントサービス */
    @Autowired
    private AccountService accountService;

    @GetMapping(ApiUri.ACCOUNT)
    public ApiResponseOptional<GetAccountByUserIdResponse> getAccountByUserId() {

        // ユーザ詳細情報取得
        UserMst dto = accountService.getUserListByUserId();

        // レスポンス返却
        return new ApiResponseOptional<>(ResultCode.C000, createResponse(dto));
    }

    GetAccountByUserIdResponse createResponse(UserMst dto) {

        if(isNull(dto)) return new GetAccountByUserIdResponse();

        return new GetAccountByUserIdResponse()
                .setUserId(dto.getUserId())
                .setUserName(dto.getUserName())
                .setAuthority(getRole(dto.getAuthority()))
                .setVersion(dto.getVersion());
    }

}
