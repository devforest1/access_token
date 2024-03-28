package com.study.signin.api.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberDto {
    // 사용자 ID
    @NotBlank
    private String loginId;
    // 사용자 비밀번호
    @NotBlank
    private String password;
    // 사용자 이름
    @NotBlank
    private String name;
    // 사용자 이메일
    private String email;

    @Builder
    public MemberDto(String loginId, String password, String name, String email) {
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.email = email;
    }
}
