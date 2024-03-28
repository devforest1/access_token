package com.study.signin.api.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginDto {
    // 사용자 아이디
    @NotBlank
    private String loginId;
    // 사용자 비밀번호
    @NotBlank
    private String password;
}
