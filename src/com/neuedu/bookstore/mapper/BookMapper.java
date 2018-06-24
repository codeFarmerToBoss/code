package com.neuedu.bookstore.mapper;

import java.util.List;

import com.neuedu.bookstore.bean.Book;
import com.neuedu.bookstore.bean.Pager;

public interface BookMapper {

	public List<Book> findAll();
	
	public List<Book> findAllWithCategory();
	
	public Book findBookByIsbn(String isbn);
	
	public int editBook(Book book);
	
	public int addBook(Book book);
	
	public int deleteBook(String isbn);
	
	/*
	 * 测试多条件查询和模糊查询
	 */
	List<Book> findByExample(Book book);
	//不定條件查詢單表
	
	
	List<Book> findByIsbnList(List<String> Isbn);
	
	//分页查询
	List<Book> findBookByPager(Pager pager);
	
	//与分页查询sql条件一致的统计查询
	int countForPager(Pager pager);
}
