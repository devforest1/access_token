package com.study.signin.api.repository;

import com.study.signin.api.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    // 사용자 정보조회
    Optional<Member> findByLoginId(String loginId);
}
