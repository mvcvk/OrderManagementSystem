package com.ibm.order.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ibm.order.model.Order;
import com.ibm.order.model.OrderItem;
import com.ibm.order.model.OrderRequest;
import com.ibm.order.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository repo;
	
	@Autowired
	RestTemplate rest;
	
	public void save(OrderRequest request) {
		
		String url="http://localhost:8080/orderitem/createOrderitem";
		for(OrderItem item:request.getItems() ) {
			String reponse;
			
			reponse=rest.postForObject(url, item, String.class);
			
			System.out.println("res"+reponse);
		}
		Order order=new Order();
		order.setCustomerName(request.getCustomerName());
		order.setOrderId(request.getOrderId());
		order.setShippingAdress(request.getShippingAdress());
		order.setOrderDate(request.getOrderDate());
		order.setTotal(request.getTotal());
		repo.save(order);
	}
	
	public List<Order> getAll(){
		List<Order> orders=new ArrayList<>();
		repo.findAll().forEach(order->orders.add(order));
		return orders;
	}

}
