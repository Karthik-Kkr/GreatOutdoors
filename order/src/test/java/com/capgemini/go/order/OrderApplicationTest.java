package com.capgemini.go.order;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.go.order.exception.OrderIdNotFoundException;
import com.capgemini.go.order.model.OrderDto;
import com.capgemini.go.order.repository.IOrderRepo;
import com.capgemini.go.order.service.IOrderService;

class OrderApplicationTest {

	@Autowired
	IOrderService service;
	
	@Autowired
	IOrderRepo repository;
	
//	OrderDto orderDto=new OrderDto("101","102","103",104,"105",106,LocalDateTime.of(2020, 05, 05, 10, 30, 55),
//			LocalDateTime.of(2020, 05, 03, 05, 10, 55));
	
	@Test
	public void validateOrderId(String orderId){
		
		Exception exception = assertThrows(OrderIdNotFoundException.class, ()->{
			service.viewOrder("102");
		});
		OrderDto expectedMessage = service.viewOrder(orderId);
		String actualMessage = exception.getMessage();
		assertEquals(expectedMessage, actualMessage);
	}
	
}
