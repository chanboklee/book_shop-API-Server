package com.book.shop.dto;

import com.book.shop.domain.Address;
import com.book.shop.domain.OrderStatus;

import lombok.Data;

@Data
public class OrderSimpleQueryDto {

	private Long orderId;
	private String name;
	private OrderStatus orderStatus;
	private Address address;
	
	public OrderSimpleQueryDto(Long orderId, String name, OrderStatus orderStatus, Address address) {
		this.orderId = orderId;
		this.name = name;
		this.orderStatus = orderStatus;
		this.address = address;
	}
}
