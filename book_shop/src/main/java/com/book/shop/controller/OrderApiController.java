package com.book.shop.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.book.shop.domain.Address;
import com.book.shop.domain.Delivery;
import com.book.shop.domain.DeliveryStatus;
import com.book.shop.domain.Member;
import com.book.shop.domain.Order;
import com.book.shop.domain.OrderStatus;
import com.book.shop.dto.OrderSimpleQueryDto;
import com.book.shop.response.CreateOrderResponse;
import com.book.shop.service.MemberService;
import com.book.shop.service.OrderService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class OrderApiController {
	
	private final OrderService orderService;
	private final MemberService memberService;
	
	@PostMapping("/members/{memberId}/orders")
	public ResponseEntity<CreateOrderResponse> saveOrder(@PathVariable(name = "memberId") Long memberId) {
		
		Member findMember = memberService.getMember(memberId);
		Address address = findMember.getAddress();
		
		Delivery delivery = new Delivery(address, DeliveryStatus.READY);	
		Order order = Order.createOrder(findMember, delivery, OrderStatus.ORDER);
		orderService.saveOrder(order);
		
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/members/"+memberId+"/orders").toUriString());
		return ResponseEntity.created(uri).body(new CreateOrderResponse(order.getId()));
	}
	
	@GetMapping("/members/{memberId}/orders{orderId}")
	public ResponseEntity<OrderDto> getOrder(@PathVariable(name = "memberId") Long memberId,
											 @PathVariable(name = "orderId") Long orderId) {
		Order order = orderService.getOrder(memberId, orderId);
		return ResponseEntity.ok().body(new OrderDto(order, order.getMember().getName(), order.getDelivery().getAddress()));
	}
	
	@Data
	@AllArgsConstructor
	static class OrderDto {
		private Order order;
		private String name;
		private Address address;
	}
	
	@GetMapping("/members/{memberId}/orders")
	public ResponseEntity<Result> getOrders(@PathVariable(name = "memberId") Long memberId) {
		List<OrderSimpleQueryDto> orders = orderService.getOrders(memberId).stream()
																   		   .map(o -> new OrderSimpleQueryDto(o.getId(),
																		   							 		 o.getMember().getName(),
																		   							 		 o.getOrderStatus(),
																		   							 		 o.getDelivery().getAddress()))
																   		   .collect(Collectors.toList());
		return ResponseEntity.ok().body(new Result(orders));
	}
	
	@Data
	@AllArgsConstructor
	static class Result<T> {
		private T orderData;
	}
}
