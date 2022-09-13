package com.example.tmpSpringBoot.request.account;

import javax.validation.constraints.*;

import com.example.tmpSpringBoot.validations.*;

import lombok.*;

/**
 * API010 - パスワード再設定機能 リクエスト
 */
@Data
public class EditQuestionRequest {

    /** ユーザID */
    @NotNull
    @Size(min = 12, max = 12)
    private String userId;

    /** 新パスワード */
    @NotNull
    @HalfAlphanumeric
    @Size(min = 1, max = 20)
    private String newPassword;

    /** 秘密の質問 */
    @NotNull
    @HalfAlphanumeric
    @Size(min = 7, max = 7)
    private String secretId;

    /** 秘密の答え */
    @NotNull
    @HalfAlphanumeric
    @Size(min = 1, max = 200)
    private String secretAnswer;
}

