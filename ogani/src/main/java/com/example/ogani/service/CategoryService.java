package com.example.ogani.service;

import com.example.ogani.dto.CategoryDTO;
import com.example.ogani.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    List<Category> getListEnabled();

    Category createCategory(CategoryDTO categoryDTO);

    Category updateCategory(Long id,CategoryDTO categoryDTO);

    void deleteCategory(Long id);

    void enableCategory(Long id);

}
