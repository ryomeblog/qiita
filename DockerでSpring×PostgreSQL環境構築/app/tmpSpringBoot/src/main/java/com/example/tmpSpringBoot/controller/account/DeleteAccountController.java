package com.example.tmpSpringBoot.controller.account;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import com.example.tmpSpringBoot.constant.*;
import com.example.tmpSpringBoot.controller.*;
import com.example.tmpSpringBoot.response.*;
import com.example.tmpSpringBoot.service.account.*;

/**
 * API006 - ユーザ削除機能 コントローラ
 */
@RestController
public class DeleteAccountController extends BaseController {

    /** アカウントサービス */
    @Autowired
    private AccountService accountService;

    @DeleteMapping(ApiUri.ACCOUNT)
    public ApiResponse deleteById() {

        // ユーザ削除
        accountService.deleteUser();

        // レスポンス返却
        return new ApiResponse(ResultCode.C000);
    }

}
