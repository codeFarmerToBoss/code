package com.neuedu.bookstore.service;

import java.util.List;
import java.util.Map;

import com.neuedu.bookstore.bean.Category;

public interface ICategoryService {
	public int addCategory(Category category);
	public List<Category> findAllCategory();
	public List<Category> findAllCategoryToBook();
	public List<Category> findAll();
	//修改
	public int editCategory(Category category);
	//删除
	public int deleteById(int id);
	//模糊查询
	public List<Category> searchByName(Category category);
	
	/*
	 * 注意：mybatis接口不支持方法的重载（不能有两个方法的名称相同）
	 * 
	 */
	public List<Category> searchByName2(Map<String, String> mapp);
}
