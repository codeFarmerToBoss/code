package com.neuedu.bookstore.bean;

import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class Book {

	private String isbn;
	@NotBlank(message="{bookName.out.null}")
	@Size(min=1,max=50,message = "{bookNameRange}")
	private String bookName;
	//使用包装类进行设计
	private Double price;
	private Date publishDate;
	private String publisher;
	
	//mybatis时orm框架，设计实体类时，需要把表关系转成对象关系--本例是一个多对一的关系
	private Category category;

	private String bookImage;//封面图片
	
	public Book() {
		super();
	}

	public Book(String isbn, String bookName, Double price, Date publishDate, String publisher, Category category) {
		super();
		this.isbn = isbn;
		this.bookName = bookName;
		this.price = price;
		this.publishDate = publishDate;
		this.publisher = publisher;
		this.category = category;
	}

	@Override
	public String toString() {
		return "book [isbn=" + isbn + ", bookName=" + bookName + ", price=" + price + ", publishDate=" + publishDate
				+ ", publisher=" + publisher + ", category=" + category + "]";
	}

	public String getBookImage() {
		return bookImage;
	}

	public void setBookImage(String bookImage) {
		this.bookImage = bookImage;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	

	public void setPrice(Double price) {
		this.price = price;
		
	}
	
	public Double getPrice() {
		if (price == null) {
			this.setPrice(0.0);
			return price;
		} else {
			return price;
		}
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	
}
