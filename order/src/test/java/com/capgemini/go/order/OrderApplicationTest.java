package com.capgemini.go.order;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.capgemini.go.order.exception.OrderIdNotFoundException;
import com.capgemini.go.order.model.OrderDto;
import com.capgemini.go.order.repository.IOrderRepo;
import com.capgemini.go.order.service.IOrderService;

@SpringBootTest
class OrderApplicationTest {

	@Autowired
	IOrderService service;

	@Autowired
	IOrderRepo repository;

	@Test
	public void testOrderId() {
		
		Boolean order=repository.existsById("101");
		assertNotNull(order);
		
	}

	@Test
	public void testOrderNotFoundException() {

		Exception exception = assertThrows(OrderIdNotFoundException.class, () -> {
			service.viewOrder("789");
		});
		String expectedMessage = "The given OrderId is not present";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	public void testOrderList() {

		List<OrderDto> orderList = repository.findAll();
		assertNotNull(orderList);
	}

	@Test
	public void testCancelOrder() {

		Exception exception = assertThrows(OrderIdNotFoundException.class, () -> {
			service.cancelOrder("197");
		});
		String expectedMessage = "The given OrderId is not present";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.contains(actualMessage));
	}
}