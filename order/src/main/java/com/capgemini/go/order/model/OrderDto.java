package com.capgemini.go.order.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_dto")
public class OrderDto {

	@Id
	private String orderId;
	private String userId;
	private String productId;
	private int productUniqueNo;
	private String addressId;
	private int orderDispatcherStatus;
	private LocalDate orderInitiateTime;
	private LocalDate orderDispatchTime;

	public OrderDto() {
		super();

	}

	public OrderDto(String orderId, String userId, String productId, int productUniqueNo, String addressId,
			int orderDispatcherStatus, LocalDate orderInitiateTime, LocalDate orderDispatchTime) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.productId = productId;
		this.productUniqueNo = productUniqueNo;
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

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public int getProductUniqueNo() {
		return productUniqueNo;
	}

	public void setProductUniqueNo(int i) {
		this.productUniqueNo = i;
	}

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public int getOrderDispatcherStatus() {
		return orderDispatcherStatus;
	}

	public void setOrderDispatcherStatus(int orderDispatcherStatus) {
		this.orderDispatcherStatus = orderDispatcherStatus;
	}

	public LocalDate getOrderInitiateTime() {
		return orderInitiateTime;
	}

	public void setOrderInitiateTime(LocalDate orderInitiateTime) {
		this.orderInitiateTime = orderInitiateTime;
	}

	public LocalDate getOrderDispatchTime() {
		return orderDispatchTime;
	}

	public void setOrderDispatchTime(LocalDate orderDispatchTime) {
		this.orderDispatchTime = orderDispatchTime;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addressId == null) ? 0 : addressId.hashCode());
		result = prime * result + ((orderDispatchTime == null) ? 0 : orderDispatchTime.hashCode());
		result = prime * result + orderDispatcherStatus;
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((orderInitiateTime == null) ? 0 : orderInitiateTime.hashCode());
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + productUniqueNo;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderDto other = (OrderDto) obj;
		if (addressId == null) {
			if (other.addressId != null)
				return false;
		} else if (!addressId.equals(other.addressId))
			return false;
		if (orderDispatchTime == null) {
			if (other.orderDispatchTime != null)
				return false;
		} else if (!orderDispatchTime.equals(other.orderDispatchTime))
			return false;
		if (orderDispatcherStatus != other.orderDispatcherStatus)
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (orderInitiateTime == null) {
			if (other.orderInitiateTime != null)
				return false;
		} else if (!orderInitiateTime.equals(other.orderInitiateTime))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (productUniqueNo != other.productUniqueNo)
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrderDto [orderId=" + orderId + ", userId=" + userId + ", productId=" + productId + ", productUniqueNo="
				+ productUniqueNo + ", addressId=" + addressId + ", orderDispatcherStatus=" + orderDispatcherStatus
				+ ", orderInitiateTime=" + orderInitiateTime + ", orderDispatchTime=" + orderDispatchTime + "]";
	}
	
}