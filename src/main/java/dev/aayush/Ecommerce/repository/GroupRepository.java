package dev.aayush.Ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.aayush.Ecommerce.model.ProductGroup;

@Repository
public interface GroupRepository extends JpaRepository<ProductGroup, Long> {

}
