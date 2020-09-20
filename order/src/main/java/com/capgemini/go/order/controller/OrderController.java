package com.capgemini.go.order.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.go.order.model.OrderDto;
import com.capgemini.go.order.service.OrderServiceImpl;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	OrderServiceImpl orderService;
	
	@PostMapping("/add")
	public OrderDto addOrder(@RequestBody OrderDto orderDto) {
		
		return orderService.addOrder(orderDto);
	}
	
	@GetMapping("/orderId/{orderId}")
	public OrderDto viewOrder(@PathVariable String orderId) {
		
		return orderService.viewOrder(orderId);
	}
	
	@GetMapping("/viewAll")
	public List<OrderDto> viewAll() {
		
		return orderService.viewAll();
	}
	
	@DeleteMapping("/delete/orderId/{orderId}")
	public void deleteOrder(@PathVariable String orderId) {
		
		orderService.deleteOrder(orderId);
	}
}

