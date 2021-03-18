 package com.cg.fds.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class FoodCart {

	@Id
	@GeneratedValue
	private String cartId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="cust_Id")
	private Customer customer;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "itemId", orphanRemoval = true)
	private List<Item> itemList;
	
	
	public FoodCart() {
		super();
	}

	public FoodCart(String cartId, Customer customer, List<Item> itemList) {
		super();
		this.cartId = cartId;
		this.customer = customer;
		this.itemList = itemList;
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

	@Override
	public String toString() {
		return "FoodCart [cartId=" + cartId + ", customer=" + customer + ", itemList=" + itemList + "]";
	}
	
	
}
