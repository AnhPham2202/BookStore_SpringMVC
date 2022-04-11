package com.bookstore.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.springframework.stereotype.Component;

@Component
public class ShoppingCart implements Serializable {
	public ShoppingCart() {
	}
	
	
	private Map<Book, Integer> cart = new HashMap<Book, Integer>();
	
	public void addItem(Book book) {
		if (cart.containsKey(book)) {
			Integer quantity = cart.get(book) + 1;
			cart.put(book, quantity);
		} else {
			cart.put(book, 1);
		}
	}
	
	public void updateItem (Book book, int quantity) {
		cart.put(book, quantity);
	}
	
	public Map<Book, Integer>  getItems() {
		return this.cart;
	}
	
	public void removeItem(Book book) {
		cart.remove(book);
	}
	
	public int getTotalQuantity() {
		int total = 0; 
		for (Entry<Book, Integer> entry : cart.entrySet()) {
			total = total + entry.getValue();
		}
		return total;
	}
	
	public float getTotalMoney() {
		float total = 0; 
		for (Entry<Book, Integer> entry : cart.entrySet()) {
			float pricePerBook = entry.getKey().getPrice() * entry.getValue();
			total = total + pricePerBook;
		}
		return total;
	}
	
	public void clear() {
		this.cart.clear();
	}
	
}
