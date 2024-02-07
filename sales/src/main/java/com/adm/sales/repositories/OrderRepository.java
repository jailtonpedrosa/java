package com.adm.sales.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adm.sales.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
