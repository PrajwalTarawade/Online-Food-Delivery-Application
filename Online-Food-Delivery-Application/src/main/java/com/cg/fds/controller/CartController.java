package com.cg.fds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cg.fds.entities.FoodCart;
import com.cg.fds.entities.Item;
import com.cg.fds.exceptions.distinctRestaurantException;
import com.cg.fds.exceptions.removeFailedException;
import com.cg.fds.service.ICartService;
import com.cg.fds.service.IItemService;

@RestController
public class CartController {

	@Autowired
	ICartService CService;
	
	@Autowired
	IItemService IService;
	
	@PostMapping("/addItemToCart/{itemId}")
	public ResponseEntity<FoodCart> addItemToCart(@RequestParam("cartId") int cartId,@PathVariable int itemId) throws distinctRestaurantException{
		
		FoodCart cart1 = CService.addItemToCart(cartId,itemId);
		if(cart1==null)
		{
			throw new distinctRestaurantException("You cannot add items from different restuarant...");
		}
		FoodCart cart2=new FoodCart();
		cart2.setCartId(cart1.getCartId());
		cart2.setCustomer(cart1.getCustomer());
		return new ResponseEntity<FoodCart>(cart2, HttpStatus.OK);
		
	}
	
	@PutMapping("/increaseQuantity/{cartId}/{itemId}/{quantity}")
	public ResponseEntity<FoodCart> increaseQuantity(@PathVariable("cartId") int cart_id,@PathVariable("itemId") int item_id, @PathVariable int quantity){
		
		FoodCart cart=CService.increaseQuantity(cart_id,item_id, quantity);
		return new ResponseEntity<FoodCart>(cart, HttpStatus.OK);
	}
	
	@PutMapping("/reduceQuantity/{cartId}/{itemId}/{quantity}")
	public ResponseEntity<FoodCart>  reduceQuantity(@PathVariable("cartId") int cart_id,@PathVariable("itemId") int item_id, @PathVariable int quantity) throws removeFailedException{
		
		FoodCart cart=CService.reduceQuantity(cart_id,item_id, quantity);
		
		if(cart==null)
		{
			throw new removeFailedException("Item not present in cart !!!");
		}
		return new ResponseEntity<FoodCart>(cart, HttpStatus.OK);
	}
	
	@DeleteMapping("/removeItem")
	public ResponseEntity<String> removeItem(@RequestParam("cartId") int cartId, @RequestParam("itemId") int itemId) throws removeFailedException{
		
		FoodCart cart=CService.getCartById(cartId);
		if(cart==null)
		{
			throw new removeFailedException("Item Id is not present in cart !!!");
		}
		else
		{
			Item item=IService.viewItemById(itemId);
			String msg=CService.removeItem(cart, item);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		}	
	}
	
	@DeleteMapping("/clearCart/{cartId}")
	public ResponseEntity<String>  clearCart(@PathVariable int cartId){
		
		String msg=CService.clearCart(cartId);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
}
