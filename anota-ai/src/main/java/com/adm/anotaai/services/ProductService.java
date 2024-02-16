package com.adm.anotaai.services;

import com.adm.anotaai.model.category.Category;
import com.adm.anotaai.model.category.CategoryDTO;
import com.adm.anotaai.model.category.exceptions.CategoryNotFoundException;
import com.adm.anotaai.model.product.Product;
import com.adm.anotaai.model.product.ProductDTO;
import com.adm.anotaai.model.product.exceptions.ProductNotFoundException;
import com.adm.anotaai.repositories.CategoryRepository;
import com.adm.anotaai.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductRepository productRepository;

    public Product insert(ProductDTO productDTO) {
        Category category = this.categoryService.findById(productDTO.categoryID())
                .orElseThrow(CategoryNotFoundException::new);
        Product product = new Product(productDTO);
        product.setCategory(category);
        this.productRepository.save(product);
        return product;
    }

    public Product update(UUID id, ProductDTO productDTO) {
        Product product = this.productRepository.findById(id)
                .orElseThrow(ProductNotFoundException::new);

        this.categoryService.findById(productDTO.categoryID())
                .ifPresent(product::setCategory);

        if(!productDTO.title().isEmpty()) {
            product.setTitle(productDTO.title());
        }

        if(!productDTO.description().isEmpty()) {
            product.setDescription(productDTO.description());
        }

        if(!(productDTO.price() == null)) {
            product.setPrice(productDTO.price());
        }

        this.productRepository.save(product);

        return product;
    }

    public void delete(UUID id) {
        Product product = this.productRepository.findById(id)
                .orElseThrow(ProductNotFoundException::new);

        this.productRepository.delete(product);
    }

    public List<Product> getAll() {
        return this.productRepository.findAll();
    }
}
