package com.book.shop.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.shop.domain.Address;
import com.book.shop.domain.Delivery;
import com.book.shop.domain.DeliveryStatus;
import com.book.shop.domain.Member;
import com.book.shop.domain.Order;
import com.book.shop.domain.OrderStatus;
import com.book.shop.service.MemberService;
import com.book.shop.service.OrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class OrderApiController {
	
	private final OrderService orderService;
	private final MemberService memberService;
	
	@PostMapping("/members/{id}/orders")
	public Long saveOrder(@PathVariable(name = "id") Long memberId) {
		
		System.out.println("memberId="+memberId);
		
		Member findMember = memberService.getMember(memberId);
		Address address = findMember.getAddress();
		
		Delivery delivery = new Delivery(address, DeliveryStatus.READY);
		
		Order order = new Order(delivery, findMember);
		// Order order = Order.createOrder(findMember, delivery, OrderStatus.ORDER);
	
		
		orderService.saveOrder(order);
		
		return order.getId();
	}
}
