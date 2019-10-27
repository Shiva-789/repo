package com.product.myretail.repository;

import org.springframework.data.repository.CrudRepository;


import com.product.myretail.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{
}
