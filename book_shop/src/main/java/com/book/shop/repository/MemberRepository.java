package com.book.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.shop.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{

	boolean existsByUserIdAndUserPw(String userId, String userPw);
}
