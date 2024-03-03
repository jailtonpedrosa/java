package com.adm.productapi.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.adm.productapi.dtos.ProductRecordDto;
import com.adm.productapi.models.ProductModel;
import com.adm.productapi.repositories.ProductRepository;
import com.adm.productapi.services.exceptions.DatabaseException;
import com.adm.productapi.services.exceptions.ResourceNotFoundException;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	public ProductModel insert(ProductRecordDto productRecordDto) {
		var productModel = new ProductModel();
		BeanUtils.copyProperties(productRecordDto, productModel);
		productRepository.save(productModel);
		return productModel;
	}
	
	public List<ProductModel> getAllProducts() {
		List<ProductModel> products = this.productRepository.findAll();
		return products;
	}
	
	public ProductModel findById(UUID idProduct) {
		Optional<ProductModel> product = this.productRepository.findById(idProduct);
		return product.orElseThrow(() -> new ResourceNotFoundException(idProduct));
	}
	
	public ProductModel update(ProductModel productModel, ProductRecordDto productRecordDto) {
		BeanUtils.copyProperties(productRecordDto, productModel);
		productRepository.save(productModel);
		return productModel;
	}
	
	public void delete(UUID id) {
		try {
			productRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}		
	}
}
