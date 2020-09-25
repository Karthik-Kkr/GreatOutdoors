/***************************************************************
 -Author                : Karthikeswar Rao
 -Created/Modified Date : 22/09/2020
 -Description           : OrderServiceImpl is the implementation of 
 								IOrderService for Order ms
****************************************************************/


package com.capgemini.go.order.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.go.order.exception.CancelException;
import com.capgemini.go.order.exception.OrderIdNotFoundException;
import com.capgemini.go.order.model.OrderDto;
import com.capgemini.go.order.repository.IOrderRepo;

@Service
public class OrderServiceImpl implements IOrderService {

	@Autowired
	IOrderRepo orderRepository;

	@Autowired
	private Random random;

	LocalDate date = LocalDate.now();
	LocalDate dispatchDate = date.plusDays(2);
	Period cantCancel = Period.between(dispatchDate, date.plusDays(100));

	/*************************************************
	 -FunctionName          : addOrder()
	 -Input Parameters      : OrderDto orderDto
	 -Return Type           : OrderDto
	 -Author				: Karthikeswar Rao 
	 -Creation Date			: 22/09/2020
	**************************************************/
	
	@Override
	public OrderDto addOrder(OrderDto orderDto) {
		
		orderDto.setProductUniqueNo(random.nextInt());
		orderDto.setOrderInitiateTime(date);
		orderDto.setOrderDispatchTime(dispatchDate);
		
		return orderRepository.save(orderDto);
	}

	/*************************************************
	 -FunctionName          : viewOrder()
	 -Input Parameters      : String orderId
	 -Return Type           : OrderDto
	 -Throws				: OrderIdNotFoundException
	 -Author				: Karthikeswar Rao 
	 -Creation Date			: 22/09/2020
	**************************************************/
	
	@Override
	public OrderDto viewOrder(String orderId) {

		if (!orderRepository.existsById(orderId)) {
			throw new OrderIdNotFoundException("The given OrderId is not present");
		}

		if (orderId == " ") {
			throw new OrderIdNotFoundException("OrderId should not be null");
		}

		return orderRepository.getOne(orderId);
	}

	/*************************************************
	 -FunctionName          : viewAll()
	 -Return Type           : List<OrderDto>
	 -Author				: Karthikeswar Rao 
	 -Creation Date			: 22/09/2020
	**************************************************/
	
	@Override
	public List<OrderDto> viewAll() {

		return orderRepository.findAll();
	}

	/*************************************************
	 -FunctionName          : cancelOrder()
	 -Input Parameters      : String orderId
	 -Return Type           : String
	 -Throws				: OrderIdNotFoundException, CancelException
	 -Author				: Karthikeswar Rao 
	 -Creation Date			: 22/09/2020
	**************************************************/
	
	@Override
	public String cancelOrder(String orderId) {

		if (!orderRepository.existsById(orderId)) {
			throw new OrderIdNotFoundException("The given OrderId is not present");
		}
		if (cantCancel == Period.between(dispatchDate, date.plusDays(100))) {
			throw new CancelException("You cannot cancel your order because it was already dispatched");
		}
		orderRepository.deleteById(orderId);
		return "Your order is deleted";
	}

	/*************************************************
	 -FunctionName          : dispatchDate()
	 -Return Type           : String
	 -Author				: Karthikeswar Rao 
	 -Creation Date			: 22/09/2020
	**************************************************/
	
	@Override
	public String dispatchDate() {

		return "You have ordered your item on " + date + ". So " + dispatchDate + " will be your Dispatch date.";
	}
}