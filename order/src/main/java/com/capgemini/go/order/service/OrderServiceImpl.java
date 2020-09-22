package com.capgemini.go.order.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.go.order.exception.CancelException;
import com.capgemini.go.order.exception.OrderIdNotFoundException;
import com.capgemini.go.order.exception.ProductNotFoundException;
import com.capgemini.go.order.model.OrderDto;
import com.capgemini.go.order.repository.IOrderRepo;

@Service
public class OrderServiceImpl implements IOrderService {

	@Autowired
	IOrderRepo orderRepository;
	
	@Autowired
	private Random random;
	
	LocalDate date=LocalDate.now();
	LocalDate dispatchDate=date.plusDays(2);
	LocalDate cantCancel=dispatchDate.MAX;
	
	@Override
	public OrderDto addOrder(OrderDto orderDto) {
		
		orderDto.setProductUniqueNo(random.nextInt());
		orderDto.setOrderInitiateTime(LocalDateTime.now());
		orderDto.setOrderDispatchTime(LocalDateTime.of(date.plusDays(2), LocalTime.now()));
		
		return orderRepository.save(orderDto);
	}

	@Override
	public OrderDto viewOrder(String orderId) {
	
		if(!orderRepository.existsById(orderId)) {
			throw new OrderIdNotFoundException("The given OrderId is not present");
		}
		
		return orderRepository.getOne(orderId);
	}

	@Override
	public List<OrderDto> viewAll() {
		
		return orderRepository.findAll();
	}

	@Override
	public void cancelOrder(String orderId) {
		
		if(!orderRepository.existsById(orderId)) {
			throw new OrderIdNotFoundException("The given OrderId is not present");
		}
		if((dispatchDate.compareTo(cantCancel))>0 || (dispatchDate.compareTo(cantCancel)==0)) {
			throw new CancelException("You cannot cancel your order because it was already dispatched");
		}
		orderRepository.deleteById(orderId); 
	}

	@Override
	public void cancelProduct(String orderId,String productId) {

		if(!orderRepository.existsById(orderId)) {
			throw new OrderIdNotFoundException("The given OrderId or ProductId is not present");
		}
		if(!orderRepository.findAll().contains(orderRepository.existsProductId(productId))) {
			throw new ProductNotFoundException("The given ProductId is not valid");
		}				
		orderRepository.deleteById(productId);
	}

	@Override
	public String dispatchDate() {
		
		return "You have ordered your item on "+ date +". So "+ dispatchDate + " will be your Dispatch date";
	}
}