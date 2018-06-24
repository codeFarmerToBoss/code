package com.neuedu.bookstore.bean;

import java.util.Date;
import java.util.List;

public class Cart {

	private int cartId;
	private Date createDate;
	private Customer customer;
	
	
	
	public Cart() {
		super();
	}
	public Cart(int cartId, Date createDate, Customer customer) {
		super();
		this.cartId = cartId;
		this.createDate = createDate;
		this.customer = customer;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
}
