package com.codewithyash.blog.services.impl;

import java.util.List;


import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.codewithyash.blog.entities.Category;
import com.codewithyash.blog.entities.exceptions.ResourceNotFoundException;
import com.codewithyash.blog.payloads.CategoryDto;
import com.codewithyash.blog.repositories.CategoryRepo;
import com.codewithyash.blog.services.CategoryService;


public class CategoryServiceImpl implements CategoryService{
	
	@Autowired(required=true)
	private CategoryRepo categoryRepo;

	@Autowired(required=true)
	private ModelMapper modelMapper;
	
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		// TODO Auto-generated method stub
		Category cat = this.modelMapper.map(categoryDto, Category.class);
		Category addedCat = this.categoryRepo.save(cat);
		return this.modelMapper.map(addedCat, CategoryDto.class);
	}

	@Override
	public CategoryDto updatecategory(CategoryDto categoryDto, Integer categoryId) {
		// TODO Auto-generated method stub
		Category cat = this.categoryRepo.findById(categoryId)
		           .orElseThrow(()-> new ResourceNotFoundException("Category ","Category Id ",categoryId));
		cat.setCategoryTitle(categoryDto.getCategoryTitle());
		cat.setCategoryDescription(categoryDto.getCategoryDescription());
		
		Category updatedcat = this.categoryRepo.save(cat);
		return this.modelMapper.map(updatedcat,CategoryDto.class);
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		Category cat = this.categoryRepo.findById(categoryId)
		           .orElseThrow(()-> new ResourceNotFoundException("Category ","category id ",categoryId));
		this.categoryRepo.delete(cat);;
	}

	@Override
	public CategoryDto getCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		Category cat = this.categoryRepo.findById(categoryId)
		           .orElseThrow(()-> new ResourceNotFoundException("Category ","category id ",categoryId));
		
		return this.modelMapper.map(cat,CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getCategories() {
		// TODO Auto-generated method stub
		List<Category> categories = this.categoryRepo.findAll();
		List<CategoryDto> catDtos = categories.stream().map((cat)->this.modelMapper.map(cat, CategoryDto.class)).collect(Collectors.toList());
		
		return catDtos;
	}

}
