package com.adm.anotaai.controllers;

import com.adm.anotaai.model.category.Category;
import com.adm.anotaai.model.category.CategoryDTO;
import com.adm.anotaai.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<Category> insert(@RequestBody CategoryDTO categoryDTO) {
        Category category = this.categoryService.insert(categoryDTO);
        return ResponseEntity.ok().body(category);
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAll() {
        List<Category> categories = this.categoryService.getAll();
        return ResponseEntity.ok().body(categories);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> update(@PathVariable("id") UUID id, @RequestBody CategoryDTO categoryDTO) {
        Category category = this.categoryService.update(id, categoryDTO);
        return ResponseEntity.ok().body(category);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Category> delete(@PathVariable("id") UUID id) {
        this.categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
