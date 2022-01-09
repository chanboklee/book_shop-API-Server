package com.book.shop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
	private Long id;				// PK
	private String name;			// �̸�
	private String userId;			// ���� ���̵�
	private String userPw;			// ���� ��й�ȣ 
	
	
	public Member(String name, String userId, String userPw) {
		this.name = name;
		this.userId = userId;
		this.userPw = userPw;
	}
}
