package com.cg.fds.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Item {

	@Id
	@GeneratedValue
	private String itemId;
	private String itemName;
	private int quantity;
	private double cost;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="cat_Id")
	private Category category;
	
	
	@ManyToMany(mappedBy = "itemList")
	private List<Restaurant> restaurants;
	

	public Item() {
		super();
	}


	public Item(String itemId, String itemName, Category category, int quantity, double cost,
			List<Restaurant> restaurants) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.category = category;
		this.quantity = quantity;
		this.cost = cost;
		this.restaurants = restaurants;
	}


	public String getItemId() {
		return itemId;
	}


	public void setItemId(String itemId) {
		this.itemId = itemId;
	}


	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public double getCost() {
		return cost;
	}


	public void setCost(double cost) {
		this.cost = cost;
	}


	public List<Restaurant> getRestaurants() {
		return restaurants;
	}


	public void setRestaurants(List<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}


	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", category=" + category + ", quantity=" + quantity
				+ ", cost=" + cost + ", restaurants=" + restaurants + "]";
	}
	
	
	
	
	
}