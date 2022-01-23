package com.book.shop.domain;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Delivery {
	
	@Id
	@GeneratedValue
	@Column(name = "delivery_id")
	private Long id;

	@Embedded
	private Address address;
	
	@OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
	private Order order;
	
	@Enumerated(EnumType.STRING)
	private DeliveryStatus status;

	public void setOrder(Order order) {
		this.order = order;
	}
	
	public Delivery(Address address, DeliveryStatus status) {
		this.address = address;
		this.status = status; 
	}
}
