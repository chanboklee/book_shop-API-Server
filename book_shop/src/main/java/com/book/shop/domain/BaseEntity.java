package com.book.shop.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(value = AuditingEntityListener.class)
public abstract class BaseEntity {
	
	@CreatedDate
	@Column(updatable = false)
	private LocalDateTime createDate;			// 생성일자
	
	@LastModifiedDate
	private LocalDateTime modifiedDate;			// 수정일자
}
