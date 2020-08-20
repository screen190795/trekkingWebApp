package com.rbprjojects.trekkingwebapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rbprjojects.trekkingwebapp.entity.Product;



@Repository
public interface ProductRepository extends CrudRepository <Product, Long> { 
    List<Product> findByName(String name); 
   
}