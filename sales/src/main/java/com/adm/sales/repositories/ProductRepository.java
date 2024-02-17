package com.adm.sales.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adm.sales.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
