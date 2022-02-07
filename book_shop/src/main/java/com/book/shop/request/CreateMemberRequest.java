package com.book.shop.request;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class CreateMemberRequest {
	
	@NotBlank(message = "이름을 입력해주세요.")
	private String name;
	
	@NotBlank(message = "아이디를 입력해주세요.")
	private String userId;
	
	@NotBlank(message = "비밀번호를 입력해주세요.")
	private String userPw;
	
	private String city;
	private String zipcode;
	private String street; 
}
