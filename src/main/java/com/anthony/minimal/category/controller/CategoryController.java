package com.anthony.minimal.category.controller;

import com.anthony.minimal.category.domain.Category;
import com.anthony.minimal.category.service.CategoryService;
import com.anthony.minimal.web.controller.DefaultController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("category")
public class CategoryController extends DefaultController<Category, CategoryService> {

}
