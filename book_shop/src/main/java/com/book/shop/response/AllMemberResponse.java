package com.book.shop.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AllMemberResponse<T> {
	private int count;
	private T memberData;
}
