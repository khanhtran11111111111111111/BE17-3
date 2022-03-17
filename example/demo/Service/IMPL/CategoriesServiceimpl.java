package com.example.demo.Service.IMPL;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.CategoriesEntity;
import com.example.demo.Repository.CategoriesRepository;
import com.example.demo.Service.CategoriesService;
import com.example.demo.exception.ResourceNotFoundException;

@Service
public class CategoriesServiceimpl implements CategoriesService{

	private CategoriesRepository categoriesRepository;
	public CategoriesServiceimpl(CategoriesRepository categoriesRepository) {
		super();
		this.categoriesRepository=categoriesRepository;
	}
	@Override
	public CategoriesEntity saveCategory(CategoriesEntity category) {
		category.setIs_delete(false);
		category.setCreated_date(new Date());
		return categoriesRepository.save(category);
	}

	@Override
	public List<CategoriesEntity> getAllCategory() {
		return categoriesRepository.findAll();
	}

	@Override
	public CategoriesEntity getCategoryById(long id) {
		return categoriesRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category", "Id", id));
	}

	@Override
	public CategoriesEntity updateCategory(CategoriesEntity category, long id) {
		CategoriesEntity existingCategory=categoriesRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category", "Id", id));
		existingCategory.setCode(category.getCode());
		existingCategory.setCategoryname(category.getCategoryname());
		existingCategory.setCreated_by(category.getCreated_by());
		existingCategory.setDescription(category.getDescription());
		existingCategory.setUpdate_by(category.getUpdate_by());
		existingCategory.setUpdate_date(new Date());
		
		
		//save toDB
		categoriesRepository.save(existingCategory);
		
		return existingCategory;
	}

	@Override
	public void deleteCategories(long id) {
		// TODO Auto-generated method stub
				categoriesRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Categories", "Id", id));
				categoriesRepository.deleteById(id);
	}

}
