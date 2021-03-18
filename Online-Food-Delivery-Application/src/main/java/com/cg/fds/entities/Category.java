package com.cg.fds.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {

	@Id
	@GeneratedValue
	private String catId;
	private String categoryName;
	
	@OneToMany(mappedBy = "itemId")
	List<Item> list;
	
	public Category() {
		super();
	}

	public Category(String catId, String categoryName) {
		super();
		this.catId = catId;
		this.categoryName = categoryName;
	}

	public String getCatId() {
		return catId;
	}


	public void setCatId(String catId) {
		this.catId = catId;
	}


	public String getCategoryName() {
		return categoryName;
	}


	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


	@Override
	public String toString() {
		return "Category [catId=" + catId + ", categoryName=" + categoryName + "]";
	}
	
	
	
}
