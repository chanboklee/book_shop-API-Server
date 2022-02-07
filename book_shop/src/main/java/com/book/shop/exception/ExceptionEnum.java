package com.book.shop.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum ExceptionEnum {
	
	RUN_TIME_EXCEPTION(HttpStatus.BAD_REQUEST, "E0001"),
	ACCESS_DENIED_EXCEPTION(HttpStatus.BAD_REQUEST, "E0002"),
	INTERNAL_SERVER_ERROR(HttpStatus.BAD_REQUEST, "E0003"),
	MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "M0001", "ȸ���� �̹� �����մϴ�."),
	NOT_ENOUGH_STOCK(HttpStatus.NOT_FOUND, "S0001", "��� �����ϴ�."),
	SECURITY_01(HttpStatus.UNAUTHORIZED, "S0001", "������ �����ϴ�."),
	
	NOT_BLANK(HttpStatus.BAD_REQUEST, "NB001");

	private final HttpStatus status;
	private final String code; 
	private String message;
	
	ExceptionEnum(HttpStatus status, String code) {
		this.status = status;
		this.code = code;
	}
	
	ExceptionEnum(HttpStatus status, String code, String message) {
		this.status = status;
		this.code = code;
		this.message = message;
	}
}
