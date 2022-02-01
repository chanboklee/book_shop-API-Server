package com.book.shop.domain.item;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@DiscriminatorValue(value = "M")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Movie extends Item{
	
	private String director;	// 감독
	private String actor;		// 배우
}
