package com.devithedev.eazystore.repository;

import com.devithedev.eazystore.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}