package com.example.ogani.service.impl;

import com.example.ogani.dto.CategoryDTO;
import com.example.ogani.entity.Category;
import com.example.ogani.exception.NotFoundException;
import com.example.ogani.repository.CategoryRepository;
import com.example.ogani.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<Category> findAll() {
    List<Category> categories = categoryRepository.findAll(Sort.by("id").descending());
        return categories;
    }

    @Override
    public List<Category> getListEnabled() {
        List<Category> categories = categoryRepository.findAllByEnabled();
        return categories;
    }

    @Override
    public Category createCategory(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setName(categoryDTO.getName());
        category.setEnable(false);
        categoryRepository.save(category);
        return category;
    }

    @Override
    public Category updateCategory(Long id, CategoryDTO categoryDTO) {
        Category category = categoryRepository.findById(id).orElseThrow(()-> new NotFoundException("Category not found with id: " + id));
        category.setName(categoryDTO.getName());
        categoryRepository.save(category);
        return category;
    }

    @Override
    public void deleteCategory(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(()-> new NotFoundException("Category not found with id: " + id));
        categoryRepository.delete(category);
    }

    @Override
    public void enableCategory(Long id) {
    Category category = categoryRepository.findById(id).orElseThrow(()-> new NotFoundException("Category not found with id: " + id));

    if(category.isEnable()){
        category.setEnable(false);
    }else {
        category.setEnable(true);
    }
    categoryRepository.save(category);
    }
}
