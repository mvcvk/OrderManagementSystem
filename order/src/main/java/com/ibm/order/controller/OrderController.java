/**
 * 
 */
package com.ibm.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.order.model.Order;
import com.ibm.order.model.OrderRequest;
import com.ibm.order.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	OrderService service;

	@PostMapping("/createorder")
	public Integer createOrder(@RequestBody OrderRequest order) {
		service.save(order);
		return order.getOrderId();
	}

	@GetMapping("/getAll")
	public List<Order> getAll() {
		return service.getAll();
	}

}
