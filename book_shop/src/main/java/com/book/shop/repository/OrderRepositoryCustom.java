package com.book.shop.repository;

import java.util.List;

import com.book.shop.domain.Order;

public interface OrderRepositoryCustom {

	List<Order> getOrders(Long memberId);
	Order getOrder(Long memberId, Long orderId);
	
}
