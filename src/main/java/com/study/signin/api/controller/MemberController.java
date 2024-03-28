package com.study.signin.api.controller;

import com.study.signin.api.dto.LoginDto;
import com.study.signin.api.dto.MemberDto;
import com.study.signin.api.service.MemberService;
import com.study.signin.common.dto.BaseResponse;
import com.study.signin.common.status.ResultCode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Member")
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @Operation(summary = "회원가입", description = "회원정보를 추가한다.")
    @PostMapping("/signup")
    public BaseResponse<Void> signUp(@RequestBody @Valid MemberDto memberDto) {
        memberService.signUp(memberDto);
        return new BaseResponse<>(ResultCode.SUCCESS_SIGNUP, ResultCode.SUCCESS_SIGNUP.getMessage());
    }

    @Operation(summary = "로그인", description = "사용자 ID와 비밀번호로 로그인한다.")
    @PostMapping("/login")
    public BaseResponse<Void> login(@RequestBody @Valid LoginDto loginDto) {
        memberService.login(loginDto);
        return new BaseResponse<>(ResultCode.SUCCESS_LOGIN, ResultCode.SUCCESS_LOGIN.getMessage());
    }
}
