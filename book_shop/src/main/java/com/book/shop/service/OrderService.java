package com.book.shop.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.book.shop.repository.OrderRepository;
import com.book.shop.service.impl.OrderServiceImpl;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService implements OrderServiceImpl {
	
	private final OrderRepository orderRepository;
	
	

}
