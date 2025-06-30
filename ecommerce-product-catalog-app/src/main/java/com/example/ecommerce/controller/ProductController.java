package com.example.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping
	@PostMapping("products/list")
	public String listProducts(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		System.out.println("Loaded products: " + productService.getAllProducts().size());
		return "product-list";
	}

	@PostMapping("products")
	public ResponseEntity<Product> addProduct(@RequestBody @Valid Product product) {

		Product pro = productService.addProduct(product);

		return new ResponseEntity<>(pro, HttpStatus.CREATED);
	}

	@GetMapping("products/{productId}")
	public ResponseEntity<Product> getProduct(@PathVariable("productId") Integer productId) {

		Product pro = productService.getProduct(productId);

		return new ResponseEntity<>(pro, HttpStatus.OK);
	}

	@GetMapping("products")
	public ResponseEntity<List<Product>> getAllProduct() {

		List<Product> pro = productService.getAllProducts();

		return new ResponseEntity<>(pro, HttpStatus.OK);
	}

	@PutMapping("products/{productId}")
	public ResponseEntity<Product> updateProduct(@PathVariable("productId") Integer productId,
			@RequestBody @Valid Product product) {

		Product pro = productService.updateProduct(productId, product);

		return new ResponseEntity<>(pro, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("products/{productId}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Product> removeProduct(@PathVariable("productId") Integer productId) {

		Product pro = productService.removeProduct(productId);

		return new ResponseEntity<>(pro, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public String viewProduct(@PathVariable Integer id, Model model) {
		model.addAttribute("product", productService.getProduct(id));
		return "product-detail";
	}

}
