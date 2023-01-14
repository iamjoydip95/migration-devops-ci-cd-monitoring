package com.myapp.devops.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myapp.devops.model.OrderItem;

public interface OrderItemsRepository extends JpaRepository<OrderItem,Integer> {
}
