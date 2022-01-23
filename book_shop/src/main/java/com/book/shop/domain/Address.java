package com.book.shop.domain;

import javax.persistence.Embeddable;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Address {

	private String street;
	private String zipcode;
	private String city;
	
	@Builder
	public Address(String city, String zipcode, String street) {
		this.city = city;
		this.zipcode = zipcode;
		this.street = street;
	}
}
