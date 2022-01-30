package com.book.shop.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.jpa.impl.JPAQueryFactory;

@SpringBootTest
@Transactional
public class MemberServiceTest {

	@PersistenceContext
	EntityManager em;
	
	JPAQueryFactory queryFactory;
	
	@BeforeEach
	void before() {
		queryFactory = new JPAQueryFactory(em);
	}
}
