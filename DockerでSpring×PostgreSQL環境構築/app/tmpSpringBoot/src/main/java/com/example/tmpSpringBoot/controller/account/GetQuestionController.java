package com.example.tmpSpringBoot.controller.account;

import java.util.*;
import java.util.stream.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import com.example.tmpSpringBoot.constant.*;
import com.example.tmpSpringBoot.controller.*;
import com.example.tmpSpringBoot.dto.generator.*;
import com.example.tmpSpringBoot.response.*;
import com.example.tmpSpringBoot.response.account.*;
import com.example.tmpSpringBoot.service.account.*;

/**
 * API009 - 秘密の質問検索機能 コントローラ
 */
@RestController
public class GetQuestionController extends BaseController {

    /** アカウントサービス */
    @Autowired
    private AccountService accountService;

    @GetMapping(ApiUri.QUESTION)
    public ApiResponseOptional<GetQuestionResponse> getQuestion() {

        // ユーザリスト
        List<CommonMst> dtoList = accountService.getQuestion();

        // レスポンス返却
        return new ApiResponseOptional<>(ResultCode.C000, createResponse(dtoList));
    }

    GetQuestionResponse createResponse(List<CommonMst> dtoList) {
        // レスポンス作成
        GetQuestionResponse optional = new GetQuestionResponse();

        // レスポンス格納
        optional.setQuestionList(dtoList.stream().map(
                dto -> new GetQuestionResponse.Question()
                        .setCommonId(dto.getCommonId())
                        .setCommonName(dto.getCommonName())
                        .setCommonGroup(dto.getCommonGroup())
                        .setCommonValue1(dto.getCommonValue1())
                        .setCommonValue2(dto.getCommonValue2()))
                .collect(Collectors.toList()));

        return optional;
    }

}
