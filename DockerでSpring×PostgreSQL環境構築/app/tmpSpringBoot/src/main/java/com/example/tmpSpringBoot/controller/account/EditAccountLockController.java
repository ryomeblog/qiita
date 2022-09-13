package com.example.tmpSpringBoot.controller.account;

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
 * API007 - ユーザロック機能 コントローラ
 */
@RestController
public class EditAccountLockController extends BaseController {

    /** アカウントサービス */
    @Autowired
    private AccountService accountService;

    @PutMapping(ApiUri.ACCOUNT_LOCK)
    public ApiResponse editAccount(
            @RequestBody @Validated EditAccountLockRequest request, BindingResult bindingResult) {
        // バリデーションチェック
        valid(bindingResult);

        // ユーザ更新
        accountService.editUser((createDto(request)));

        // レスポンス返却
        return new ApiResponse(ResultCode.C000);
    }

    UserMst createDto(EditAccountLockRequest request) {
        // DTO作成
        UserMst dto = new UserMst();
        dto.setUserId(request.getUserId());
        dto.setLock(toBoolean(request.getLock()));
        dto.setUpdateDatetime(new Date());
        dto.setVersion(toShort(request.getVersion()));
        return dto;
    }

}
