package com.example.tmpSpringBoot.controller.account;

import static com.example.tmpSpringBoot.common.CommonUtils.*;
import static com.example.tmpSpringBoot.common.Functions.*;

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
 * API005 - ユーザ編集機能 コントローラ
 */
@RestController
public class EditAccountController extends BaseController {

    /** アカウントサービス */
    @Autowired
    private AccountService accountService;

    @PutMapping(ApiUri.ACCOUNT)
    public ApiResponse edit(
            @RequestBody @Validated EditAccountRequest request, BindingResult bindingResult) {
        // バリデーションチェック
        valid(bindingResult);

        // ユーザ更新
        accountService.editUser((createDto(request)));

        // レスポンス返却
        return new ApiResponse(ResultCode.C000);
    }

    UserMst createDto(EditAccountRequest request) {
        // DTO作成
        UserMst dto = new UserMst();
        dto.setUserId(getLoginUserId());
        dto.setUserName(request.getUserName());
        dto.setPassword(passwordEncode(request.getPassword()));
        dto.setUpdateDatetime(new Date());
        dto.setVersion(toShort(request.getVersion()));
        return dto;
    }

}
