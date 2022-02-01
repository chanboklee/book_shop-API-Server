package com.book.shop.domain.item;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@DiscriminatorValue("A")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Album extends Item{
	
	private String artist;	// 아티스트
	private String etc;		// 비고

}
