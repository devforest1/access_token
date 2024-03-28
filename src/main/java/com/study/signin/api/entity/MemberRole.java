package com.study.signin.api.entity;

import com.study.signin.common.status.ROLE;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class MemberRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 30)
    @Enumerated(EnumType.STRING)
    private ROLE role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    public MemberRole(ROLE role, Member member) {
        this.role = role;
        this.member = member;
    }

    @Override
    public String toString() {
        return "MemberRole{" +
                "id=" + id +
                ", role=" + role +
                ", member=" + member +
                '}';
    }
}
