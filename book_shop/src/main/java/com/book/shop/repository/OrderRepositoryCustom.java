package com.book.shop.repository;

import java.util.List;

import com.book.shop.dto.OrderDto;

public interface OrderRepositoryCustom {

	List<OrderDto> getOrders();
	
}
