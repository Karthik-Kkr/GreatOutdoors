/***************************************************************
 -Author                : Karthikeswar Rao
 -Created/Modified Date : 22/09/2020
 -Description           : IOrderService interface for Order ms
****************************************************************/


package com.capgemini.go.order.service;

import java.util.List;
import com.capgemini.go.order.model.OrderDto;

public interface IOrderService {

	OrderDto addOrder(OrderDto orderDto);
	OrderDto viewOrder(String orderId);
	List<OrderDto> viewAll();
	String cancelOrder(String orderId);
	String dispatchDate();
}
