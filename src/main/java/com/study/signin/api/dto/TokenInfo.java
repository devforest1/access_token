package com.study.signin.api.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TokenInfo {
    private String accessToken;

    @Builder
    public TokenInfo(String accessToken) {
        this.accessToken = accessToken;
    }
}
