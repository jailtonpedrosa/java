package com.adm.anotaai.services;

import com.adm.anotaai.model.category.Category;
import com.adm.anotaai.model.category.CategoryDTO;
import com.adm.anotaai.model.category.exceptions.CategoryNotFoundException;
import com.adm.anotaai.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category insert(CategoryDTO categoryDTO) {
        Category category = new Category(categoryDTO);
        this.categoryRepository.save(category);
        return category;
    }

    public Category update(UUID id, CategoryDTO categoryDTO) {
        Category category = this.categoryRepository.findById(id)
                .orElseThrow(CategoryNotFoundException::new);

        if(!categoryDTO.title().isEmpty()) {
            category.setTitle(categoryDTO.title());
        }

        if(!categoryDTO.description().isEmpty()) {
            category.setDescription(categoryDTO.description());
        }

        this.categoryRepository.save(category);

        return category;
    }

    public void delete(UUID id) {
        Category category = this.categoryRepository.findById(id)
                .orElseThrow(CategoryNotFoundException::new);

        this.categoryRepository.delete(category);
    }

    public List<Category> getAll() {
        return this.categoryRepository.findAll();
    }

    public Optional<Category> findById(UUID id) {
        return this.categoryRepository.findById(id);
    }
}
