package com.products.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.products.apirest.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	Product findById(long id) ;
	
}
