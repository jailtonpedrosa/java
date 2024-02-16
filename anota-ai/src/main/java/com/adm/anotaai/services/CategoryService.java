package com.adm.anotaai.services;

import com.adm.anotaai.model.category.Category;
import com.adm.anotaai.model.category.CategoryDTO;
import com.adm.anotaai.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category insert(CategoryDTO categoryDTO) {
        Category category = new Category(categoryDTO);
        this.categoryRepository.save(category);
        return category;
    }

    public List<Category> getAll() {
        return this.categoryRepository.findAll();
    }
}
