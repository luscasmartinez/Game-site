package com.rp3.marco4.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rp3.marco4.models.Product;

public interface ProductRepository extends JpaRepository<Product, String> {
    List<Product> findAllByActiveTrue();
}