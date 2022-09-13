package com.example.tmpSpringBoot.request.login;

import javax.validation.constraints.*;

import com.example.tmpSpringBoot.validations.*;

import lombok.*;

/**
 * API001 - ログイン機能 リクエスト
 */
@Data
public class LoginRequest {

    /** ユーザID */
    @NotNull
    @HalfAlphanumeric
    @Size(min = 12, max = 12)
    private String userId;

    /** パスワード */
    @NotNull
    @HalfAlphanumeric
    @Size(min = 1, max = 20)
    private String password;
}
