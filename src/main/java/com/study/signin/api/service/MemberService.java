package com.study.signin.api.service;

import com.study.signin.api.dto.LoginDto;
import com.study.signin.api.dto.MemberDto;
import com.study.signin.api.dto.TokenInfo;
import org.springframework.stereotype.Service;

@Service
public interface MemberService {
    // 회원가입
    void signUp(MemberDto memberDto);

    // 로그인
    TokenInfo login(LoginDto loginDto);
}
