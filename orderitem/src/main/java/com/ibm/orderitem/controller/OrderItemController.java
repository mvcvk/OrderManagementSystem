package com.ibm.orderitem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.orderitem.model.OrderItem;
import com.ibm.orderitem.service.OrderItemService;

@RestController
@RequestMapping("/orderitem")
public class OrderItemController {

	@Autowired
	OrderItemService service;

	@GetMapping("/getAll")
	public List<OrderItem> getAll() {
		return service.getAll();
	}

	@PostMapping("/createOrderitem")
	public int save(@RequestBody OrderItem item) {
		service.save(item);
		return item.getProductCode();
	}
	
	@GetMapping("/getOrder/{productcode}")
	public Optional<OrderItem> getOrder(@PathVariable Integer productcode) {
		return service.getOrder(productcode);
	}
}
