package com.book.shop.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity{

	@Id
	@GeneratedValue
	@Column(name = "member_id")
	private Long id;									// PK
	private String name;								// 이름
	private String userId;								// 유저 아이디
	private String userPw;								// 유저 비밀번호 
	
	@Embedded
	private Address address;							// 주소
	
	@OneToMany(mappedBy = "member")
	private List<Order> orders = new ArrayList<>();		// 주문
	
	public Member(String name, String userId, String userPw, Address address) {
		this.name = name;
		this.userId = userId;
		this.userPw = userPw;
		this.address = address;
	}
}
