package com.example.tmpSpringBoot.response.account;

import lombok.*;

/**
 * API008 - ユーザ登録機能 レスポンス
 */
@Data
@AllArgsConstructor
public class CreateAccountResponse {

    /** ユーザID */
    private String userId;
}
