package com.adm.productapi.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adm.productapi.dtos.ProductRecordDto;
import com.adm.productapi.models.ProductModel;
import com.adm.productapi.repositories.ProductRepository;

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
}
