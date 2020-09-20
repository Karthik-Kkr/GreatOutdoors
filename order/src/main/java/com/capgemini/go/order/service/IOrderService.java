package com.capgemini.go.order.service;

import java.util.List;
import com.capgemini.go.order.model.OrderDto;

public interface IOrderService {

	OrderDto addOrder(OrderDto orderDto);
	OrderDto viewOrder(String orderId);
	List<OrderDto> viewAll();
	void deleteOrder(String orderId);

}
