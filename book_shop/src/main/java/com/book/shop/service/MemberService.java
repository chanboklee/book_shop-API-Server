package com.book.shop.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.book.shop.domain.Member;
import com.book.shop.exception.ApiException;
import com.book.shop.exception.ExceptionEnum;
import com.book.shop.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {
	
	private final MemberRepository memberRepository;
	
	// ȸ�� ����
	@Transactional
	public Long saveMember(Member member) {
		boolean validateDuplicateResult = validateDuplicateMember(member);
		if(validateDuplicateResult) {
			throw new ApiException(ExceptionEnum.MEMBER_NOT_FOUND);
		}else {
			memberRepository.save(member);
			return member.getId();
		}
	}
	
	private boolean validateDuplicateMember(Member member) {
		return memberRepository.existsUserIdAndUserPw(member.getUserId(),
											   		  member.getUserPw());
	}

	// ��ü ȸ�� ��ȸ
	public List<Member> getMembers() {
		// TODO Auto-generated method stub
		return memberRepository.findAll();
	}

	// ȸ�� ��ȸ
	public Member getMember(Long memberId) {
		// TODO Auto-generated method stub
		return memberRepository.findById(memberId).orElse(null);
	}
}
