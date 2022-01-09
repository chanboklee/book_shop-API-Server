package com.book.shop.exception;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ApiExceptionEntity {

	private String errorCode;
	private String errorMessage;
	
	public ApiExceptionEntity(String errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
}
