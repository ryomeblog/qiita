package com.example.tmpSpringBoot.controller.login;

import static com.example.tmpSpringBoot.common.CommonUtils.*;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.validation.*;
import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.*;

import com.example.tmpSpringBoot.constant.*;
import com.example.tmpSpringBoot.controller.*;
import com.example.tmpSpringBoot.dto.generator.*;
import com.example.tmpSpringBoot.request.login.*;
import com.example.tmpSpringBoot.response.*;
import com.example.tmpSpringBoot.response.login.*;
import com.example.tmpSpringBoot.service.login.*;

/**
 * API001 - ログイン機能 コントローラ
 */
@RestController
public class LoginController extends BaseController {

    /** ログインサービス */
    @Autowired
    private LoginService loginService;

    @PostMapping(ApiUri.LOGIN)
    public ApiResponseOptional<LoginResponse> login(
            @RequestBody @Validated LoginRequest body, BindingResult bindingResult,
            HttpServletRequest request, HttpServletResponse response) {
        // バリデーションチェック
        valid(bindingResult);

        // ログイン処理
        UserMst cookUserMst = loginService.login(body.getUserId(), body.getPassword());

        // レスポンス返却
        return new ApiResponseOptional<>(ResultCode.C000, toLoginResponse(cookUserMst));
    }

    LoginResponse toLoginResponse(UserMst cookUserMst) {
        // レスポンス作成
        return new LoginResponse(
                cookUserMst.getUserId(),
                cookUserMst.getUserName(),
                getRole(cookUserMst.getAuthority()),
                cookUserMst.getVersion());
    }

}
