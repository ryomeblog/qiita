package com.example.tmpSpringBoot.request.account;

import javax.validation.constraints.*;

import com.example.tmpSpringBoot.validations.*;

import lombok.*;

/**
 * API007 - ユーザロック機能 リクエスト
 */
@Data
public class EditAccountLockRequest {

    /** ユーザID */
    @NotNull
    @Size(min = 12, max = 12)
    private String userId;

    /** ロック */
    @BooleanType
    private String lock;

    /** バージョン */
    @NotNull
    @ShortType(min = 0)
    private String version = "0";
}
