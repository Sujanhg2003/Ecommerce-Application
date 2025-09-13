package com.mtd.ecommerce_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mtd.ecommerce_app.dto.OrderDetailsDto;
import com.mtd.ecommerce_app.dto.OrderStatusDto;
import com.mtd.ecommerce_app.dto.PlaceOrderDto;
import com.mtd.ecommerce_app.entity.Order;
import com.mtd.ecommerce_app.service.OrderService;

@RestController
@RequestMapping("/orders")
@CrossOrigin("*")
public class OrderController {
	
	@Autowired OrderService orderService;
	
	@PostMapping("/save")
	public Order saveOrder(@RequestBody PlaceOrderDto order) {
		return orderService.createOrder(order);
	}
	
	@GetMapping("/all")
	public List<Order> viewAllOrder(){
		return orderService.findAllOrders();
	}
	
	@GetMapping("/order/{id}")
	public OrderDetailsDto getOrderDetails(@PathVariable String id) {
		return orderService.getOrderDetails(id);
	}
	
	
	@PutMapping("/update/{id}")
	public Order UpdateStatus(@PathVariable String id,@RequestBody OrderStatusDto orderStatusDto) {
		return orderService.updateOrderStatus(id, orderStatusDto);
	}
	
}
