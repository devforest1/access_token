package com.study.signin.common.exception;

import com.study.signin.common.status.ResultCode;
import lombok.Getter;

@Getter
public class ExistValidException extends RuntimeException{
    private final ResultCode resultCode;
    private final String message;

    public ExistValidException(ResultCode resultCode, String message) {
        this.resultCode = resultCode;
        this.message = message;
    }
}
