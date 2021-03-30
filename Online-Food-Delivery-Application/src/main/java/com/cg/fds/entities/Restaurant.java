package com.cg.fds.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Restaurant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int restaurantId;
	@NotEmpty(message = "Enter valid restaurant name")
	@Size(min = 2,max = 10,message = "Name should be within range")
	private String restaurantName;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="addId")
	private Address address;
	
//	@OneToMany(cascade = CascadeType.ALL,mappedBy = "restaurant", orphanRemoval =  true)
//	private List<Item> itemList = new ArrayList<>();
	
	private String managerName;
	private String contactNumber;
	
	public Restaurant() {
		// TODO Auto-generated constructor stub
	}

	public Restaurant(String restaurantName, Address address, List<Item> itemList, String managerName,
			String contactNumber) {
		super();
		this.restaurantName = restaurantName;
		this.address = address;
		//this.itemList = itemList;
		this.managerName = managerName;
		this.contactNumber = contactNumber;
	}
	
	
	public Restaurant(int restaurantId, String restaurantName, Address address, List<Item> itemList, String managerName,
			String contactNumber) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.address = address;
		//this.itemList = itemList;
		this.managerName = managerName;
		this.contactNumber = contactNumber;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	/*public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}*/

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName + ", address="
				+ address + ", managerName=" + managerName + ", contactNumber=" + contactNumber + "]";
	}

	/*@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName + ", address="
				+ address + ", itemList=" + itemList + ", managerName=" + managerName + ", contactNumber="
				+ contactNumber + "]";
	}*/
	

	

}
