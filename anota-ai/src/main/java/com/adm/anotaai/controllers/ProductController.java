package com.adm.anotaai.controllers;

import com.adm.anotaai.model.category.Category;
import com.adm.anotaai.model.category.CategoryDTO;
import com.adm.anotaai.model.product.Product;
import com.adm.anotaai.model.product.ProductDTO;
import com.adm.anotaai.services.CategoryService;
import com.adm.anotaai.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Product> insert(@RequestBody ProductDTO productDTO) {
        Product product = this.productService.insert(productDTO);
        return ResponseEntity.ok().body(product);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        List<Product> products = this.productService.getAll();
        return ResponseEntity.ok().body(products);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable("id") UUID id, @RequestBody ProductDTO productDTO) {
        Product product = this.productService.update(id, productDTO);
        return ResponseEntity.ok().body(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> delete(@PathVariable("id") UUID id) {
        this.productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
