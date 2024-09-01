package com.anthony.minimal.category.service;

import com.anthony.minimal.category.domain.Category;
import com.anthony.minimal.category.domain.repository.CategoryRepository;
import com.anthony.minimal.web.service.DefaultService;
import org.springframework.stereotype.Service;

@Service
public class CategoryService extends DefaultService<Category, CategoryRepository> {
}
