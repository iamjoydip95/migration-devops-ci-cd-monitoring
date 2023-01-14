package com.myapp.devops.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myapp.devops.model.Product;

public interface ProductRepository extends JpaRepository<Product,Integer>{
	
Optional<List<Product>>	 findByProductName(String productName);

Optional<List<Product>>	 findByPriceGreaterThanEqual(Double price);

}
