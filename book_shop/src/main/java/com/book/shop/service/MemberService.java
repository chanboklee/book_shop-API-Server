package com.book.shop.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.book.shop.domain.Member;
import com.book.shop.exception.ApiException;
import com.book.shop.exception.ExceptionEnum;
import com.book.shop.repository.MemberRepository;
import com.book.shop.service.impl.MemberServiceImpl;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService implements MemberServiceImpl{
	
	private final MemberRepository memberRepository;

	// 회원 저장
	@Override
	@Transactional
	public Long saveMember(Member member) {
		// TODO Auto-generated method stub
		boolean validateDuplicateResult = validateDuplicateMember(member);
		if(validateDuplicateResult) {
			throw new ApiException(ExceptionEnum.MEMBER_NOT_FOUND);
		}else {
			memberRepository.save(member);
			return member.getId();
		}
	}
	
	private boolean validateDuplicateMember(Member member) {
		return memberRepository.existsByUserIdAndUserPw(member.getUserId(),
														member.getUserPw());
	}

	// 전체 회원 조회
	@Override
	public List<Member> getMembers() {
		// TODO Auto-generated method stub
		return memberRepository.findAll();
	}

	// 회원 조회
	@Override
	public Member getMember(Long memberId) {
		// TODO Auto-generated method stub
		return memberRepository.findById(memberId).orElse(null);
	}
	
	@Override
	public Member findByName(String name) {
		// TODO Auto-generated method stub
		return memberRepository.findByName(name);
	}
}
