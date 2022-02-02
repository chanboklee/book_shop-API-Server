package com.book.shop.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.book.shop.domain.Address;
import com.book.shop.domain.Member;

@SpringBootTest
@Rollback(false)
@Transactional
public class MemberServiceTest {

//	@PersistenceContext
//	EntityManager em;
//	
//	JPAQueryFactory queryFactory;
//	
//	@BeforeEach
//	void before() {
//		queryFactory = new JPAQueryFactory(em);
//	}
	
	@Autowired MemberService memberService;
	
	@BeforeEach
	void before() {
		Address address = Address.builder().city("��õ")
										   .street("����")
										   .zipcode("123-1")
										   .build();
		
		Member member = Member.builder().name("������")
										.userId("lcb")
										.userPw("1234")
										.address(address)
										.build();
		
		memberService.saveMember(member);
	}
	
	@Test
	@DisplayName("ȸ������ �׽�Ʈ")
	void saveMemberTest() {
		Address address = Address.builder()
								 .city("��õ")
								 .street("������")
								 .zipcode("402-1")
								 .build();
		
		Member member = Member.builder()
							  .userId("lcb")
							  .userPw("1234")
							  .name("������")
							  .address(address)
							  .build();
		
		memberService.saveMember(member);
	}
	
	@Test
	@DisplayName("ȸ�� �̸� �˻� �׽�Ʈ")
	void getMemberByName() {
		Member findMember = memberService.findByName("������");
		Assertions.assertThat(findMember.getUserPw()).isEqualTo("1234");
		Assertions.assertThat(findMember.getUserId()).isEqualTo("lcb");
		Assertions.assertThat(findMember.getAddress().getCity()).isEqualTo("��õ");
	}
}
