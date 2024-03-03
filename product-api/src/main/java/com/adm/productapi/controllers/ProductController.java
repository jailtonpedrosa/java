package com.adm.productapi.controllers;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.adm.productapi.dtos.ProductRecordDto;
import com.adm.productapi.models.ProductModel;
import com.adm.productapi.services.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@PostMapping
	public ResponseEntity<ProductModel> saveProduct(@RequestBody @Valid ProductRecordDto productRecordDto) {
		var productModel = this.productService.insert(productRecordDto);
		
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(productModel.getIdProduct()).toUri();

		return ResponseEntity.created(uri).body(productModel);
	}
	
	@GetMapping
	public ResponseEntity<List<ProductModel>> getAllProducts() {
		return ResponseEntity.ok().body(this.productService.getAllProducts());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductModel> getOneProduct(@PathVariable(value = "id") UUID id) {
		var productModel = this.productService.findById(id);
		return ResponseEntity.ok().body(productModel);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ProductModel> updateProduct(@PathVariable(value = "id") UUID id, 
			@RequestBody @Valid ProductRecordDto productRecordDto) {		
		var productModel = this.productService.findById(id);
		return ResponseEntity.ok().body(this.productService.update(productModel, productRecordDto));		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable(value = "id") UUID id) {		
		this.productService.findById(id);
		this.productService.delete(id);
		return ResponseEntity.noContent().build();		
	}
}
