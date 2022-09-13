package com.example.tmpSpringBoot.controller.account;

import static com.example.tmpSpringBoot.common.CommonUtils.*;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.validation.*;
import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.*;

import com.example.tmpSpringBoot.constant.*;
import com.example.tmpSpringBoot.controller.*;
import com.example.tmpSpringBoot.dto.generator.*;
import com.example.tmpSpringBoot.request.account.*;
import com.example.tmpSpringBoot.response.*;
import com.example.tmpSpringBoot.service.account.*;

/**
 * API010 - パスワード再設定機能 コントローラ
 */
@RestController
public class EditQuestionController extends BaseController {

    /** アカウントサービス */
    @Autowired
    private AccountService accountService;

    @PutMapping(ApiUri.QUESTION)
    public ApiResponse edit(
            @RequestBody @Validated EditQuestionRequest request, BindingResult bindingResult) {
        // バリデーションチェック
        valid(bindingResult);

        // パスワード更新
        accountService.editQuestion(createDto(request));

        // レスポンス返却
        return new ApiResponse(ResultCode.C000);
    }

    UserMst createDto(EditQuestionRequest request) {
        // DTO作成
        UserMst dto = new UserMst();
        dto.setUserId(request.getUserId());
        dto.setPassword(passwordEncode(request.getNewPassword()));
        dto.setSecretId(request.getSecretId());
        dto.setSecretAnswer(request.getSecretAnswer());
        dto.setUpdateDatetime(new Date());
        return dto;
    }

}
