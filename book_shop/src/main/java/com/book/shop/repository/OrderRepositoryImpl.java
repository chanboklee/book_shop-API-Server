package com.book.shop.repository;

import java.util.List;

import javax.persistence.EntityManager;

import static com.book.shop.domain.QOrder.order;
import static com.book.shop.domain.QMember.member;

import com.book.shop.dto.OrderDto;
import com.querydsl.jpa.impl.JPAQueryFactory;

public class OrderRepositoryImpl implements OrderRepositoryCustom {
	
	private final JPAQueryFactory queryFactory;
	
	public OrderRepositoryImpl(EntityManager em) {
		this.queryFactory = new JPAQueryFactory(em);
	}

	@Override
	public List<OrderDto> getOrders() {
		// TODO Auto-generated method stub
//		queryFactory.select(order.id)
//				    .from(order)
//				    .join(order.member, member).fetchJoin()
//				    .join(order.delivery, delivery)
				    
				    
		
		
		return null;
	}
}
