package com.neuedu.bookstore.bean;

import java.util.Date;
import java.util.List;

public class CartItem {

	private int cartItem;
	private int count;
	private Date addTime;
	
	private Cart cart;
	private List<Book> books;
	
	public CartItem() {
		super();
	}
	public CartItem(int cartItem, int count, Date addTime, Cart cart, List<Book> books) {
		super();
		this.cartItem = cartItem;
		this.count = count;
		this.addTime = addTime;
		this.cart = cart;
		this.books = books;
	}
	public int getCartItem() {
		return cartItem;
	}
	public void setCartItem(int cartItem) {
		this.cartItem = cartItem;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	
	
}
