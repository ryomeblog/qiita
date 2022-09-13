package com.example.tmpSpringBoot.response.account;

import lombok.*;
import lombok.experimental.*;

/**
 * API004 - ユーザ詳細検索機能 レスポンス
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class GetAccountByUserIdResponse {

    /** ユーザID */
    private String userId;

    /** ユーザ名 */
    private String userName;

    /** 権限 */
    private String authority;

    /** バージョン */
    private Short version;

}
