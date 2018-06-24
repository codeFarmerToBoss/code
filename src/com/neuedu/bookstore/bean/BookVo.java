package com.neuedu.bookstore.bean;

import java.util.List;

public class BookVo {

	private List<Book> books;
	
	public BookVo() {
		super();
	}

	public BookVo(List<Book> books) {
		super();
		this.books = books;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	
	
}
