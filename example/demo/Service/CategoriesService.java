package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.CategoriesEntity;


public interface CategoriesService {
	CategoriesEntity saveCategory(CategoriesEntity category);
	List<CategoriesEntity> getAllCategory();
	CategoriesEntity getCategoryById(long id);
	CategoriesEntity updateCategory(CategoriesEntity category, long id);
	void deleteCategories(long id);
}
