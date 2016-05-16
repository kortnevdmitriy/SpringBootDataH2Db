package com.apple.oa.repository;

import org.springframework.data.repository.CrudRepository;

import com.apple.oa.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
