package com.neuedu.bookstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.bookstore.bean.Book;
import com.neuedu.bookstore.bean.Pager;
import com.neuedu.bookstore.mapper.BookMapper;
import com.neuedu.bookstore.service.IBookService;

/*
 * 在业务层进行spring+mybatis的代码整合， 在业务层调用mybatis进行数据库操作，同事需要进行事务管理
 */

@Service
@Transactional
public class BookServiceImpl implements IBookService {

	//业务层整合数据访问层 - 使用注解方式注入mybatis代理类
	@Autowired
	private BookMapper BookMapper;
	
	@Override
	public List<Book> findAll() {
		return BookMapper.findAll();
	}

	@Override
	public List<Book> findAllWithCategory() {
		return BookMapper.findAllWithCategory();
	}

	@Override
	public Book findBookByIsbn(String isbn) {
		return BookMapper.findBookByIsbn(isbn);
	}

	@Override
	public boolean editBook(Book book) {
		if(BookMapper.editBook(book) == 1) {
			return true;
		}else {
			return false;
		}
		
	}
	
	@Override
	public boolean addBook(Book book) {
		if(BookMapper.addBook(book) == 1) {
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public List<Book> findByExample(Book book) {
		return BookMapper.findByExample(book);
	}



	@Override
	public List<Book> findByIsbnList(List<String> Isbn) {
		return BookMapper.findByIsbnList(Isbn);
	}

	@Override
	public List<Book> findBookByPager(Pager pager) {
		return BookMapper.findBookByPager(pager);
	}

	@Override
	public int countForPager(Pager pager) {
		return BookMapper.countForPager(pager);
	}

	@Override
	public boolean deleteBook(String isbn) {
		if(BookMapper.deleteBook(isbn) == 1) {
			return true;
		}else {
			return false;
		}
	}

}
