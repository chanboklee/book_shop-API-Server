package com.book.shop.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@DiscriminatorValue("B")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Book extends Item{
	
	private String author;			// ÀúÀÚ
	private String isbn;			// isbn

}
