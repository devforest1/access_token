package com.study.signin.common.status;

public enum ResultCode {
    SUCCESS("정상적으로 성공했습니다."),
    SUCCESS_LOGIN("정상적으로 로그인에 성공했습니다."),
    SUCCESS_SIGNUP("정상적으로 회원가입에 성공했습니다."),
    EXIST_MEMBER("이미 등록된 사용자입니다."),
    NOT_EXIST_MEMBER("존재하지 않은 사용자입니다."),
    CHECK_PASSWORD("비밀번호를 확인해주세요."),
    BAD_CREDENTIAL("인증에 실패했습니다."),
    ERROR("에러가 발생했습니다.");
    private final String message;

    ResultCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
