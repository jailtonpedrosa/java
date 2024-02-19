package com.adm.sales.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adm.sales.model.OrderItem;
import com.adm.sales.model.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}
