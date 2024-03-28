package com.study.signin.api.entity;

import com.study.signin.common.status.ROLE;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Member {
    @Id
    @Column(name = "member_id", unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // 사용자 아이디
    @Column(name = "login_id", nullable = false)
    private String loginId;

    // 사용자 비밀번호
    @Column(name = "password", nullable = false)
    private String password;

    // 사용자 이름
    @Column(name = "\"name\"", nullable = false)
    private String name;

    // 사용자 이메일
    @Column(name = "email")
    private String email;

    // 생성일시
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    // 수정일시
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "member")
    private List<MemberRole> memberRoles = new ArrayList<>();

    @Builder
    public Member(String loginId, String password, String name, String email, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.email = email;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", loginId='" + loginId + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", memberRoles=" + memberRoles +
                '}';
    }
}
