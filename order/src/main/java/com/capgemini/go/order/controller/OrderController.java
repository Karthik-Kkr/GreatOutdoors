/*****************************************
 -Author                : Karthikeswar Rao
 -Created/Modified Date : 22/09/2020
 -Description           : Controller for Adding, viewing and
  							deleting the order
******************************************/

package com.capgemini.go.order.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.go.order.model.OrderDto;
import com.capgemini.go.order.service.IOrderService;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {

	@Autowired
	IOrderService orderService;
	
	/*************************************************
	 -FunctionName          : addOrder()
	 -Input Parameters      : OrderDto orderDto
	 -Return Type           : OrderDto
	 -Author				: Karthikeswar Rao 
	 -Creation Date			: 22/09/2020
	 -EndPointUrl           : /add
	**************************************************/

	@PostMapping("/add")
	public OrderDto addOrder(@RequestBody OrderDto orderDto) {
		
		return orderService.addOrder(orderDto);
	}
	
	/*************************************************
	 -FunctionName          : viewOrder()
	 -Input Parameters      : String orderId
	 -Return Type           : OrderDto
	 -Author				: Karthikeswar Rao 
	 -Creation Date			: 22/09/2020
	 -EndPointUrl           : /orderId/{orderId}
	**************************************************/

	@GetMapping("/orderId/{orderId}")
	public OrderDto viewOrder(@PathVariable String orderId) {

		return orderService.viewOrder(orderId);
	}
	
	/*************************************************
	 -FunctionName          : viewAll()
	 -Return Type           : List<OrderDto>
	 -Author				: Karthikeswar Rao 
	 -Creation Date			: 22/09/2020
	 -EndPointUrl           : /viewAll
	**************************************************/

	@GetMapping("/viewAll")
	public List<OrderDto> viewAll() {

		return orderService.viewAll();
	}
	
	/*************************************************
	 -FunctionName          : cancelOrder()
	 -Input Parameters      : String orderId
	 -Return Type           : String
	 -Author				: Karthikeswar Rao 
	 -Creation Date			: 22/09/2020
	 -EndPointUrl           : /delete/orderId/{orderId}
	**************************************************/

	@DeleteMapping("/delete/orderId/{orderId}")
	public String cancelOrder(@PathVariable String orderId) {

		return orderService.cancelOrder(orderId);
	}

	/*************************************************
	 -FunctionName          : dispatchDate()
	 -Return Type           : String
	 -Author				: Karthikeswar Rao 
	 -Creation Date			: 22/09/2020
	 -EndPointUrl           : /dispatcherDate/{orderId}
	**************************************************/
	
	@GetMapping("/dispatcherDate/{orderId}")
	public String dispatcherDate(@PathVariable String orderId) {

		return orderService.dispatchDate();
	}
}