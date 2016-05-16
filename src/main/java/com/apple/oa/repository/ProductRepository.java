package com.apple.oa.repository;

import org.springframework.data.repository.CrudRepository;

import com.apple.oa.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
