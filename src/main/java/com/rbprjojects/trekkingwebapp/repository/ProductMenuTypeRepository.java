package com.rbprjojects.trekkingwebapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rbprjojects.trekkingwebapp.entity.ProductMenuType;



@Repository
public interface ProductMenuTypeRepository extends CrudRepository <ProductMenuType, Long> { 
    List<ProductMenuType> findByName(String name); 
   
}
