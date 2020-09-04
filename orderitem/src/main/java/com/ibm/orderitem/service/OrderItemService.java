package com.ibm.orderitem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.orderitem.model.OrderItem;
import com.ibm.orderitem.repository.OrderRepository;

@Service
public class OrderItemService {
	
	@Autowired
	OrderRepository repo;
	
	public void save(OrderItem item) {
		repo.save(item);
	}

	public List<OrderItem> getAll(){
		List<OrderItem> items=new ArrayList<>();
		repo.findAll().forEach(item->items.add(item));
		return items;
	}
	
	public Optional<OrderItem> getOrder(Integer productCode) {
		Optional<OrderItem> item=repo.findById(productCode);
		return item;
	}
}
