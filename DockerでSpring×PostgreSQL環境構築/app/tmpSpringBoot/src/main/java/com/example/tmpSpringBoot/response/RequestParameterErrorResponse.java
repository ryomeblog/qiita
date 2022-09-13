package com.example.tmpSpringBoot.response;

import java.util.*;

import com.example.tmpSpringBoot.exception.entity.*;

import lombok.*;

/**
 * リクエストパラメータエラー レスポンス
 */
@Data
public class RequestParameterErrorResponse {

    /** エラーリスト */
    private List<ErrorParam> errorParameterList;
}
