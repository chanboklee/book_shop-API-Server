package com.book.shop.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "orders")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order {
	
	@Id
	@GeneratedValue
	@Column(name = "order_id")
	private Long id;								// PK
	
	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;						// �ֹ� enum
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id")
	private Member member;							// ȸ��
	
	@OneToMany(mappedBy = "order")
	List<OrderItem> orderItems = new ArrayList<>();	// order - item �߰����̺�
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "delivery_id")
	private Delivery delivery;
	
//	public static Order createOrder(Member member, Delivery delivery, OrderStatus status) {
//		Order order = new Order(delivery, member, status);
//		
//		return order;
//	}
	
	public Order(Delivery delivery, Member member) {
		this.delivery = delivery;
		this.member = member;
	}
	
	// �������� �޼���
	public void changeDelivery(Delivery delivery) {
		this.delivery = delivery;
		delivery.setOrder(this);
	}
	
	// �������� �޼���
	public void changeOrderItem(OrderItem orderItem) {
		orderItems.add(orderItem);
		orderItem.setOrder(this);
	}
	
	// �������� �޼���
	public void changeMember(Member member) {
		this.member = member;
		this.member.getOrders().add(this);
	}
}
