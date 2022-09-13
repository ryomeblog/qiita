package com.example.tmpSpringBoot.controller.login;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import com.example.tmpSpringBoot.constant.*;
import com.example.tmpSpringBoot.controller.*;
import com.example.tmpSpringBoot.response.*;
import com.example.tmpSpringBoot.service.login.*;

/**
 * API002 - ログアウト機能 コントローラ
 */
@RestController
public class LogoutController extends BaseController {

    /** ログインサービス */
    @Autowired
    private LoginService loginService;

    @PostMapping(ApiUri.LOGOUT)
    public ApiResponse logout() {

        // ログアウト処理
        loginService.logout();

        // レスポンス返却
        return new ApiResponse(ResultCode.C000);
    }
}
