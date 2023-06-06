package com.example.spring_test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring_test.model.product;

public interface productRepository extends JpaRepository<product, Long> {

}