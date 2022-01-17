package com.book.shop.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.shop.service.OrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class OrderApiController {
	
	private final OrderService orderService;
	
	@PostMapping("/members/{id}/orders")
	public void saveOrder(@PathVariable(name = "id") Long memberId) {
		
		
		
		
		
		
	}
}
