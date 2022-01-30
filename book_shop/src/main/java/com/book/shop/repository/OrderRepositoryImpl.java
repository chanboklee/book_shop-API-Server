package com.book.shop.repository;

import static com.book.shop.domain.QDelivery.delivery;
import static com.book.shop.domain.QMember.member;
import static com.book.shop.domain.QOrder.order;

import java.util.List;

import javax.persistence.EntityManager;

import com.book.shop.domain.Order;
import com.book.shop.dto.OrderSimpleQueryDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

public class OrderRepositoryImpl implements OrderRepositoryCustom {
	
	private final JPAQueryFactory queryFactory;
	
	public OrderRepositoryImpl(EntityManager em) {
		this.queryFactory = new JPAQueryFactory(em);
	}

	@Override
	public List<Order> getOrders(Long memberId) {
		// TODO Auto-generated method stub
		return queryFactory.select(order)
						   .from(order)
						   .join(order.member, member)
						   .fetchJoin()
						   .join(order.delivery, delivery)
						   .fetchJoin()
						   .where(order.member.id.eq(memberId))
						   .fetch();
	}
	
	@Override
	public Order getOrder(Long memberId, Long orderId) {
		// TODO Auto-generated method stub
		return queryFactory.select(order)
						   .from(order)
						   .join(order.member, member)
						   .join(order.delivery, delivery)
						   .where(order.member.id.eq(memberId)
								   	.and(order.id.eq(orderId)))
						   .fetchOne();
	}
}
