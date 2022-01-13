package com.book.shop.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class Item {
	
	@Id
	@GeneratedValue
	@Column(name = "item_id")
	private Long id;									//PK
	
	private String name;								//상품명
	private int price;									//가격
	private int stockQuantity;							//재고
	
	@OneToMany(mappedBy = "item")
	List<OrderItem> orderItems = new ArrayList<>();		//order-item 중간테이블

}
