package com.capgemini.go.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.capgemini.go.order.model.OrderDto;

public interface IOrderRepo extends JpaRepository<OrderDto, String> {

	
}