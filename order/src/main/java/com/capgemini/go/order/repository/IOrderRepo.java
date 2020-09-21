package com.capgemini.go.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capgemini.go.order.model.OrderDto;

public interface IOrderRepo extends JpaRepository<OrderDto, String>{

	@Query(value = "from OrderDto where productId=:productId")
	public OrderDto existsProductId(String productId);

}
