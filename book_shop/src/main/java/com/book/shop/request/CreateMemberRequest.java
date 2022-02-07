package com.book.shop.request;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class CreateMemberRequest {
	
	@NotBlank(message = "�̸��� �Է����ּ���.")
	private String name;
	
	@NotBlank(message = "���̵� �Է����ּ���.")
	private String userId;
	
	@NotBlank(message = "��й�ȣ�� �Է����ּ���.")
	private String userPw;
	
	private String city;
	private String zipcode;
	private String street; 
}
