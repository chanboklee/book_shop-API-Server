package com.book.shop.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.book.shop.domain.Order;
import com.book.shop.repository.OrderRepository;
import com.book.shop.service.impl.OrderServiceImpl;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService implements OrderServiceImpl {
	
	private final OrderRepository orderRepository;
	
	@Override
	@Transactional
	public Long saveOrder(Order order) {
		// TODO Auto-generated method stub
		orderRepository.save(order);
		return order.getId();
	}
}
