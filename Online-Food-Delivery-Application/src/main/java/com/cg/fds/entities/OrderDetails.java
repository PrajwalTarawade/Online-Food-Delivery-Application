package com.cg.fds.entities;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class OrderDetails {

	@Id
	@GeneratedValue
	private int orderId;
	private LocalDateTime orderDate;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="cart_Id")
	private FoodCart cart;
	private String orderStatus;
	
	
	
	public OrderDetails() {
		super();
	}

	public OrderDetails(int orderId, LocalDateTime orderDate, FoodCart cart, String orderStatus) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.cart = cart;
		this.orderStatus = orderStatus;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public FoodCart getCart() {
		return cart;
	}

	public void setCart(FoodCart cart) {
		this.cart = cart;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Override
	public String toString() {
		return "OrderDetails [orderId=" + orderId + ", orderDate=" + orderDate + ", cart=" + cart + ", orderStatus="
				+ orderStatus + "]";
	}
	
	
	

}
