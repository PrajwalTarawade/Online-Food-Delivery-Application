package com.cg.fds.service;

import com.cg.fds.entities.FoodCart;
import com.cg.fds.entities.Item;

public interface ICartService {

	public FoodCart addItemToCart(int cartId,int itemId);
	public FoodCart increaseQuantity(int cart_id,int item_id,int quantity);
	public FoodCart reduceQuantity(int cart_id,int item_id,int quantity);
	public String removeItem(FoodCart cart,Item item);
	public String clearCart(int cartId);
	public FoodCart getCartById(int cartId);
	public Item getItemById(int itemId);
		
}
