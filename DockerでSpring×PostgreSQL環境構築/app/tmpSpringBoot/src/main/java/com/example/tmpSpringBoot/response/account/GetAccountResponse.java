package com.example.tmpSpringBoot.response.account;

import java.util.*;

import lombok.*;
import lombok.experimental.*;

/**
 * API003 - ユーザ検索機能 レスポンス
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAccountResponse {

    /** 総件数 */
    private int total;

    /** ユーザリスト */
    private List<User> userList;

    @Data
    @Accessors(chain = true)
    public static class User {

        /** ユーザID */
        private String userId;

        /** ユーザ名 */
        private String userName;

        /** 権限 */
        private String authority;

        /** バージョン */
        private Short version;

    }
}
