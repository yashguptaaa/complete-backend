package com.codewithyash.blog.services;

import java.util.List;

import com.codewithyash.blog.payloads.CategoryDto;
import com.codewithyash.blog.services.CategoryService;

public interface CategoryService {

	//Create
    CategoryDto createCategory(CategoryDto categoryDto);
    
    //Update
	CategoryDto updatecategory(CategoryDto categoryDto,Integer categoryId);
	
	//Delete
	void deleteCategory(Integer categoryId);
	
	//get
	CategoryDto getCategory(Integer categoryId);
	
	//getAll
	List<CategoryDto> getCategories();
}
