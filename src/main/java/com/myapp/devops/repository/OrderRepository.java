package com.myapp.devops.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myapp.devops.model.Order;

@Repository
public interface OrderRepository  extends JpaRepository<Order, Integer> {
    

}
