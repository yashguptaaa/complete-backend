package com.codewithyash.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithyash.blog.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
