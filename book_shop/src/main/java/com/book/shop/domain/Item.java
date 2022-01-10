package com.book.shop.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item {
	
	@Id
	@GeneratedValue
	@Column(name = "item_id")
	private Long id;
	
	@OneToMany(mappedBy = "item")
	List<OrderItem> orderItems = new ArrayList<>();

}
