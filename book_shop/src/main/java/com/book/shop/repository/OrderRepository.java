package com.book.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.shop.domain.Order;

public interface OrderRepository extends JpaRepository<Order, Long>, OrderRepositoryCustom{

	
}
