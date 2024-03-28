package com.study.signin.common.dto;

import com.study.signin.common.status.ResultCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResponse<T> {
    // 상태 코드
    private final ResultCode status;
    // 데이터 객체
    private T data;
    // 메시지
    private String message;

    public BaseResponse(T data) {
        this.status = ResultCode.SUCCESS;
        this.data = data;
    }

    public BaseResponse(ResultCode status, T data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public BaseResponse(ResultCode status, String message) {
        this.status = status;
        this.message = message;
    }
}
