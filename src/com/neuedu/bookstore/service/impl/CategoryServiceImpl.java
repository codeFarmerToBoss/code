package com.neuedu.bookstore.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.bookstore.bean.Category;
import com.neuedu.bookstore.mapper.BookMapper;
import com.neuedu.bookstore.mapper.CategoryMapper;
import com.neuedu.bookstore.service.ICategoryService;


@Service
@Transactional
public class CategoryServiceImpl implements ICategoryService {

	//业务层整合数据访问层 - 使用注解方式注入mybatis代理类
	@Autowired
	private CategoryMapper categoryMapper;
	
	@Override
	public int addCategory(Category category) {
		return categoryMapper.addCategory(category);
	}

	@Override
	public List<Category> findAllCategory() {
		return categoryMapper.findAllCategory();
	}

	@Override
	public List<Category> findAllCategoryToBook() {
		return categoryMapper.findAllCategoryToBook();
	}

	@Override
	public List<Category> findAll() {
		return categoryMapper.findAll();
	}

	@Override
	public int editCategory(Category category) {
		return categoryMapper.editCategory(category);
	}

	@Override
	public int deleteById(int id) {
		return categoryMapper.deleteById(id);
	}

	@Override
	public List<Category> searchByName(Category category) {
		return categoryMapper.searchByName(category);
	}

	@Override
	public List<Category> searchByName2(Map<String, String> mapp) {
		return categoryMapper.searchByName2(mapp);
	}

}
