package com.book.shop.domain;

import java.util.ArrayList;
import java.util.List;

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
import javax.persistence.Table;

import lombok.AccessLevel;
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
	private OrderStatus status;						// �ֹ� enum
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id")
	private Member member;							// ȸ��
	
	@OneToMany(mappedBy = "order")
	List<OrderItem> orderItems = new ArrayList<>();	// order - item �߰����̺�
	
	// �������� �޼���
	public void changeMember(Member member) {
		this.member = member;
		this.member.getOrders().add(this);
	}
}
