package com.study.signin.common.service;

import com.study.signin.api.entity.Member;
import com.study.signin.api.repository.MemberRepository;
import com.study.signin.common.dto.CustomUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
    private final MemberRepository memberRepository;

    // 사용자 정보 조회
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepository.findByLoginId(username)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자는 없습니다."));
        return createuserDetails(member);
    }

    // UserDetails 로 변환
    private UserDetails createuserDetails(Member member) {
        return new CustomUser(
                member.getId(),
                member.getLoginId(),
                member.getPassword(),
                member.getMemberRoles().stream()
                        .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getRole()))
                        .collect(Collectors.toList())
        );
    }
}
