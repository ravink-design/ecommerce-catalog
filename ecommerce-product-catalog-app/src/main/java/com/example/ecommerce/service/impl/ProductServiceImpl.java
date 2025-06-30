package com.example.ecommerce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.exception.ResourceNotFoundException;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.repository.ProductRepository;
import com.example.ecommerce.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product addProduct(Product product) {
		if (product == null)
			throw new ResourceNotFoundException("Product is null");

		return productRepository.save(product);
	}

	@Override
	public Product getProduct(Integer productId) {

		return productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("No product available with this id"));
	}

	@Override
	public List<Product> getAllProducts() {

		List<Product> products = productRepository.findAll();

		if (products.isEmpty())
			throw new ResourceNotFoundException("No product available in the database");
		return products;

	}

	@Override
	public Product updateProduct(Integer productId, Product updateProduct) {

		Product existingProduct = productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Product Id: " + productId));

		// Update fields as needed
		existingProduct.setName(updateProduct.getName());
		existingProduct.setDescription(updateProduct.getDescription());
		existingProduct.setPrice(updateProduct.getPrice());
		existingProduct.setStockQuantity(updateProduct.getStockQuantity());
		existingProduct.setCategory(updateProduct.getCategory());

		return productRepository.save(existingProduct);
	}

	@Override
	public Product removeProduct(Integer productId) {
		Product existingProduct = productRepository.findById(null)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Product Id: " + productId));

		productRepository.delete(existingProduct);
		return existingProduct;
	}

}
