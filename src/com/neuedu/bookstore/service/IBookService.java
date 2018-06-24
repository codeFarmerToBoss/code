package com.neuedu.bookstore.service;

import java.util.List;

import com.neuedu.bookstore.bean.Book;
import com.neuedu.bookstore.bean.Pager;

public interface IBookService {

	public List<Book> findAll();
	
	public List<Book> findAllWithCategory();
	
	public Book findBookByIsbn(String isbn);
	
	public boolean editBook(Book book);
	
	public boolean addBook(Book book);
	
	public boolean deleteBook(String isbn);
	
	/*
	 * 测试多条件查询和模糊查询
	 */
	List<Book> findByExample(Book book);
	
	
	List<Book> findByIsbnList(List<String> Isbn);
	
	//分页查询
	List<Book> findBookByPager(Pager pager);
	
	//与分页查询sql条件一致的统计查询
	int countForPager(Pager pager);
}
