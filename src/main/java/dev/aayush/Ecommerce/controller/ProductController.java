package dev.aayush.Ecommerce.controller;

import java.util.List;

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

import dev.aayush.Ecommerce.exception.ResourceNotFoundException;
import dev.aayush.Ecommerce.model.Product;
import dev.aayush.Ecommerce.repository.ProductRepository;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	ProductRepository productRepository;

	@GetMapping("/products")
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@PostMapping("/products")
	public Product createProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}

	@GetMapping("/products/{id}")
	public Product getProductById(@PathVariable(value = "id") Long productId) {
		return productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("ProductId", "id", productId));
	}

	@PutMapping("/products/{id}") // check null at frontend
	public Product updateProduct(@PathVariable(value = "id") Long productId, @RequestBody Product productDetails) {

		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("ProductId", "id", productId));

		product.setName(productDetails.getName());
		product.setPrice(productDetails.getPrice());
		if (productDetails.getDescription() != null) {
			product.setDescription(productDetails.getDescription());
		}

		Product updatedProduct = productRepository.save(product);
		return updatedProduct;
	}

	@DeleteMapping("/products/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable(value = "id") Long productId) {
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("ProductId", "id", productId));

		productRepository.delete(product);

		return ResponseEntity.ok().build();
	}

}
