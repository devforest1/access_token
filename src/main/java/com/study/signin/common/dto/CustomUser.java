package com.study.signin.common.dto;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter
public class CustomUser extends User {
    private final Long memberId;

    public CustomUser(Long memberId, String userName, String password, Collection<? extends GrantedAuthority> authorities) {
        super(userName, password, authorities);
        this.memberId = memberId;
    }

    public Long getMemberId() { return memberId;}
}
