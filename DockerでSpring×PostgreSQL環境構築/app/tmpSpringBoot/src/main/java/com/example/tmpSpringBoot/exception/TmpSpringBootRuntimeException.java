package com.example.tmpSpringBoot.exception;

import org.springframework.http.*;

import com.example.tmpSpringBoot.constant.*;

/**
 * TmpSpringBootRuntimeException
 */
public class TmpSpringBootRuntimeException extends RuntimeException {

    /** 結果コード */
    private ResultCode resultCode;

    /** HTTPステータスコード */
    private HttpStatus httpStatus;

    /**
     * コンストラクタ
     *
     * @param e cause
     */
    public TmpSpringBootRuntimeException(Throwable e) {
        super.initCause(e);
    }

    /**
     * コンストラクタ
     *
     * @param httpStatus HTTPステータスコード
     * @param resultCode 結果コード
     */
    public TmpSpringBootRuntimeException(HttpStatus httpStatus, ResultCode resultCode) {
        this.resultCode = resultCode;
        this.httpStatus = httpStatus;
    }

    /**
     * 結果コードを取得します。
     *
     * @return 結果コード
     */
    public ResultCode getResultCode() {
        return resultCode;
    }

    /**
     * HTTPステータスコードを取得します。
     *
     * @return HTTPステータスコード
     */
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
