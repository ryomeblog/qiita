package com.example.tmpSpringBoot.controller.account;

import static com.example.tmpSpringBoot.common.CommonUtils.*;
import static com.example.tmpSpringBoot.common.Functions.*;

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
 * API008 - ユーザ登録機能 コントローラ
 */
@RestController
public class CreateAccountController extends BaseController {

    /** アカウントサービス */
    @Autowired
    private AccountService accountService;

    @PostMapping(ApiUri.SIGNUP)
    public ApiResponseOptional<CreateAccountResponse> create(
            @RequestBody @Validated CreateAccountRequest request, BindingResult bindingResult) {
        // バリデーションチェック
        valid(bindingResult);

        // ユーザ追加
        String userId = accountService.insertUser(createDto(request));

        // レスポンス返却
        return new ApiResponseOptional<>(ResultCode.C000, toCreateAccountResponse(userId));
    }

    CreateAccountResponse toCreateAccountResponse(String userId) {
        // レスポンス作成
        return new CreateAccountResponse(userId);
    }

    UserMst createDto(CreateAccountRequest request) {

        // DTO作成
        UserMst dto = new UserMst();
        dto.setUserName(request.getUserName());
        dto.setPassword(passwordEncode(request.getPassword()));
        dto.setSecretId(request.getSecretId());
        dto.setSecretAnswer(passwordEncode(request.getSecretAnswer()));
        dto.setLock(false);
        dto.setAuthority(toShort(0));
        return dto;
    }

}
