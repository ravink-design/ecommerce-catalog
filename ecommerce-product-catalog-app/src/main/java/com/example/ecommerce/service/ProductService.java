package com.example.ecommerce.service;

import java.util.List;

import com.example.ecommerce.model.Product;

public interface ProductService {

	public Product addProduct(Product product);

	public Product getProduct(Integer ProductId);

	public List<Product> getAllProducts();

	public Product removeProduct(Integer ProductId);

	Product updateProduct(Integer productId, Product updateProduct);
}
