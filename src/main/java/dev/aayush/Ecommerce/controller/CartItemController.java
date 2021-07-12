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
import dev.aayush.Ecommerce.model.CartItem;
import dev.aayush.Ecommerce.repository.CartItemRepository;

@RestController
@RequestMapping("/api")
public class CartItemController {

	@Autowired
	CartItemRepository cartItemRepository;

	@GetMapping("/cart")
	public List<CartItem> getAllCarts() {
		return cartItemRepository.findAll();
	}

	@PostMapping("/cart")
	public CartItem createCart(@RequestBody CartItem cartItem) {
		return cartItemRepository.save(cartItem);
	}

	@GetMapping("/cart/{id}")
	public CartItem getCartById(@PathVariable(value = "id") Long cartItemId) {
		return cartItemRepository.findById(cartItemId)
				.orElseThrow(() -> new ResourceNotFoundException("CartId", "id", cartItemId));
	}

	@PutMapping("/cart/{id}")
	public CartItem updateCart(@PathVariable(value = "id") Long cartItemId, @RequestBody CartItem cartDetails) {

		CartItem cartItem = cartItemRepository.findById(cartItemId)
				.orElseThrow(() -> new ResourceNotFoundException("CartId", "id", cartItemId));

		if (cartDetails.getQuantity() <= 0) {
			deleteCart(cartItemId);
		} else {
			cartItem.setQuantity(cartDetails.getQuantity());
		}
		CartItem updatedCart = cartItemRepository.save(cartItem);
		return updatedCart;
	}

	@DeleteMapping("/cart/{id}")
	public ResponseEntity<?> deleteCart(@PathVariable(value = "id") Long cartItemId) {

		CartItem cartItem = cartItemRepository.findById(cartItemId)
				.orElseThrow(() -> new ResourceNotFoundException("CartId", "id", cartItemId));

		cartItemRepository.delete(cartItem);

		return ResponseEntity.ok().build();
	}

}
