package com.ibm.orderitem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.orderitem.model.OrderItem;

@Repository
public interface OrderRepository extends JpaRepository<OrderItem, Integer> {
	
	

}
