package com.book.shop.service.impl;

import java.util.List;

import com.book.shop.domain.Member;

public interface MemberServiceImpl {

	public Long saveMember(Member member);
	List<Member> getMembers();
	Member getMember(Long memberId);
	Member findByName(String name);
}
