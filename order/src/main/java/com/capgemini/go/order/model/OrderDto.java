package com.capgemini.go.order.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_dto")
public class OrderDto {
	
	@Id
	private String orderId;
	private String userId;
	private String addressId;
	private byte orderDispatcherStatus;
	private LocalDateTime orderInitiateTime;
	private LocalDateTime orderDispatchTime;
	
	public OrderDto() {
		super();

	}

	public OrderDto(String orderId, String userId, String addressId, byte orderDispatcherStatus,
			LocalDateTime orderInitiateTime, LocalDateTime orderDispatchTime) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.addressId = addressId;
		this.orderDispatcherStatus = orderDispatcherStatus;
		this.orderInitiateTime = orderInitiateTime;
		this.orderDispatchTime = orderDispatchTime;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public byte getOrderDispatcherStatus() {
		return orderDispatcherStatus;
	}

	public void setOrderDispatcherStatus(byte orderDispatcherStatus) {
		this.orderDispatcherStatus = orderDispatcherStatus;
	}

	public LocalDateTime getOrderInitiateTime() {
		return orderInitiateTime;
	}

	public void setOrderInitiateTime(LocalDateTime orderInitiateTime) {
		this.orderInitiateTime = orderInitiateTime;
	}

	public LocalDateTime getOrderDispatchTime() {
		return orderDispatchTime;
	}

	public void setOrderDispatchTime(LocalDateTime orderDispatchTime) {
		this.orderDispatchTime = orderDispatchTime;
	}

	@Override
	public String toString() {
		return "OrderDto [orderId=" + orderId + ", userId=" + userId + ", addressId=" + addressId
				+ ", orderDispatcherStatus=" + orderDispatcherStatus + ", orderInitiateTime=" + orderInitiateTime
				+ ", orderDispatchTime=" + orderDispatchTime + "]";
	}
}
