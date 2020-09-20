package com.capgemini.go.order.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.capgemini.go.order.exception.OrderIdNotFoundException;
import com.capgemini.go.order.model.OrderDto;
import com.capgemini.go.order.repository.IOrderRepo;
import org.springframework.web.server.ResponseStatusException;

@Service
public class OrderServiceImpl implements IOrderService {

	@Autowired
	IOrderRepo orderRepository;
	
	@Override
	public OrderDto addOrder(OrderDto orderDto) {
		
		return orderRepository.save(orderDto);
	}

	@Override
	public OrderDto viewOrder(String orderId) {
		
		if(!orderRepository.existsById(orderId)) {
			throw new OrderIdNotFoundException("The given OrderId is not present");
		}
		else if(orderId==null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return orderRepository.getOne(orderId);
	}

	@Override
	public List<OrderDto> viewAll() {
		
		return orderRepository.findAll();
	}

	@Override
	public void deleteOrder(String orderId) {
		
		if(!orderRepository.existsById(orderId)) {
			throw new OrderIdNotFoundException("The given OrderId is not present");
		}
		orderRepository.deleteById(orderId); 
	}
}
