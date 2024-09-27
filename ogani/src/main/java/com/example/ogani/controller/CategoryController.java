package com.example.ogani.controller;

import com.example.ogani.dto.CategoryDTO;
import com.example.ogani.entity.Category;
import com.example.ogani.response.MessageResponse;
import com.example.ogani.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/")
    public ResponseEntity<?> getListCategory() {
        List<Category> categories = categoryService.findAll();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/enabled")
    public ResponseEntity<?> getListEnabled() {
        List<Category> categories = categoryService.getListEnabled();
        return ResponseEntity.ok(categories);
    }

    @PostMapping("/create")
    public ResponseEntity<?> creatCategory(@Valid @RequestBody CategoryDTO categoryDTO) {
        Category category = categoryService.createCategory(categoryDTO);
        return ResponseEntity.ok(category);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable Long id, @Valid @RequestBody CategoryDTO categoryDTO) {
        Category category = categoryService.updateCategory(id, categoryDTO);
        return ResponseEntity.ok(category);
    }

    @PutMapping("/enable/{id}")
    public ResponseEntity<?> enableCategory(@PathVariable Long id) {
        categoryService.enableCategory(id);
        return ResponseEntity.ok(new MessageResponse("Cập nhật thành công"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok(new MessageResponse("Xoá thành công"));
    }
}
