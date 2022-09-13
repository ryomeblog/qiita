package com.example.tmpSpringBoot.response;

import com.example.tmpSpringBoot.constant.*;

import lombok.*;

/**
 * APIレスポンス
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {

    /** 結果コード */
    private ResultCode resultCode;
}
