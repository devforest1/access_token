package com.study.signin.common;

import com.study.signin.common.dto.BaseResponse;
import com.study.signin.common.exception.ExistValidException;
import com.study.signin.common.status.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@Slf4j
@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(Exception.class)
    protected BaseResponse<Void> defaultException(Exception e) {
        log.error("[defaultException]: {}", e.getMessage());
        return new BaseResponse<>(ResultCode.ERROR, e.getMessage());
    }

    @ExceptionHandler(ExistValidException.class)
    protected BaseResponse<Void> existValidException(ExistValidException e) {
        log.error("[existValidException] {} : {}", e.getResultCode().name(), e.getMessage());
        return new BaseResponse<>(e.getResultCode(), e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected BaseResponse<Void> methodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("[invalidInputException]: {}", e.getMessage());
        List<FieldError> fieldErrors = e.getFieldErrors();
        return new BaseResponse<>(ResultCode.ERROR, fieldErrors.get(0).getDefaultMessage());
    }

    @ExceptionHandler(BadCredentialsException.class)
    protected BaseResponse<Void> badCredentialException(BadCredentialsException e) {
        log.error("[badCredentialException]: {}", e.getMessage());
        return new BaseResponse<>(ResultCode.BAD_CREDENTIAL, ResultCode.BAD_CREDENTIAL.getMessage());
    }

    @ExceptionHandler(AuthorizationServiceException.class)
    protected BaseResponse<Void> authorizationServiceException(AuthorizationServiceException e) {
        log.error("[authorizationServiceException]: {}", e.getMessage());
        return new BaseResponse<>(ResultCode.BAD_CREDENTIAL, ResultCode.BAD_CREDENTIAL.getMessage());
    }
}
