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
	private String name;								// �̸�
	private String userId;								// ���� ���̵�
	private String userPw;								// ���� ��й�ȣ 
	
	@Embedded
	private Address address;							// �ּ�
	
	@OneToMany(mappedBy = "member")
	private List<Order> orders = new ArrayList<>();		// �ֹ�
	
	public Member(String name, String userId, String userPw, Address address) {
		this.name = name;
		this.userId = userId;
		this.userPw = userPw;
		this.address = address;
	}
}
