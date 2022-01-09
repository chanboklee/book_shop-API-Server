package com.book.shop.request;

import lombok.Data;

@Data
public class CreateMemberRequest {

	private String name;
	private String userId;
	private String userPw;
}
