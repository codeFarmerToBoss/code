package com.neuedu.bookstore.bean;

import java.util.List;

public class Category {

	private int id;
	private String name;
	
	//把数据关系转换成对象关系，本例是一对多的关系
	private List<Book> books;
	
	public Category() {
		super();
	}
	public Category(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Category(int id, String name, List<Book> books) {
		super();
		this.id = id;
		this.name = name;
		this.books = books;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", books=" + books + "]";
	}
	
	
	
	
}
