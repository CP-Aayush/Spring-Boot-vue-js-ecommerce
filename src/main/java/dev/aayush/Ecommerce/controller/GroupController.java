package dev.aayush.Ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.aayush.Ecommerce.exception.ResourceNotFoundException;
import dev.aayush.Ecommerce.model.Product;
import dev.aayush.Ecommerce.model.ProductGroup;
import dev.aayush.Ecommerce.repository.GroupRepository;

@RestController
@RequestMapping("/api")
public class GroupController {
	@Autowired
	GroupRepository groupRepository;


	@GetMapping("/groups")
	public List<ProductGroup> getAllProductGroups() {
		return groupRepository.findAll();
	}

	@PostMapping("/groups")
	public ProductGroup createGroup(@RequestBody ProductGroup group) {
		return groupRepository.save(group);
	}

	@GetMapping("/groups/{id}")
	public ProductGroup getGroupById(@PathVariable(value = "id") Long groupId) {
		return groupRepository.findById(groupId)
				.orElseThrow(() -> new ResourceNotFoundException("GroupIdId", "id", groupId));
	}
}
