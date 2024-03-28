package com.study.signin.api.service;

import com.study.signin.api.dto.LoginDto;
import com.study.signin.api.dto.MemberDto;
import com.study.signin.api.dto.TokenInfo;
import com.study.signin.api.entity.Member;
import com.study.signin.api.entity.MemberRole;
import com.study.signin.api.repository.MemberRepository;
import com.study.signin.api.repository.MemberRoleRepository;
import com.study.signin.common.exception.ExistValidException;
import com.study.signin.common.jwt.JwtProvider;
import com.study.signin.common.status.ROLE;
import com.study.signin.common.status.ResultCode;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;
    private final MemberRoleRepository memberRoleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtTokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    // 사용자 회원가입
    @Override
    @Transactional
    public void signUp(MemberDto memberDto) {
        // ID 중복 검사
        Optional<Member> member = memberRepository.findByLoginId(memberDto.getLoginId());
        // 이미 등록된 아이디인 경우 예외처리 발생
        if (member.isPresent()) {
            throw new ExistValidException(ResultCode.EXIST_MEMBER, ResultCode.EXIST_MEMBER.getMessage());
        }
        // 회원정보 저장
        Member saveMember = saveMember(memberDto);
        // 회원정보 권한 저장
        saveMemberRole(saveMember);
    }

    // Member 정보 저장
    @Transactional
    public Member saveMember(MemberDto memberDto) {
        return memberRepository.save(
                Member.builder()
                        .loginId(memberDto.getLoginId())
                        .password(passwordEncoder.encode(memberDto.getPassword()))
                        .name(memberDto.getName())
                        .createdAt(LocalDateTime.now())
                        .updatedAt(LocalDateTime.now())
                        .build()
        );
    }
    // Member Role 정보 저장
    @Transactional
    public void saveMemberRole(Member member) {
        memberRoleRepository.save(
                MemberRole.builder()
                        .role(ROLE.MEMBER)
                        .member(member)
                        .build()
        );
    }

    // 로그인
    @Override
    public TokenInfo login(LoginDto loginDto) {
        // 사용자 정보 조회
        Member member = memberRepository.findByLoginId(loginDto.getLoginId())
                .orElseThrow(() -> new IllegalArgumentException(ResultCode.NOT_EXIST_MEMBER.getMessage()));
        // 비밀번호 확인
        if (!passwordEncoder.matches(loginDto.getPassword(), member.getPassword())) {
            throw new AuthorizationServiceException(ResultCode.CHECK_PASSWORD.getMessage());
        }
        // token 생성
        String accessToken = jwtTokenProvider.generateToken(loginDto);
        return TokenInfo.builder()
                .accessToken(accessToken)
                .build();
    }

    // Authentication 가져오기
    private Authentication getAuthentication(String userId, String password) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(userId, password);
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return authentication;
    }
}
