package com.rbprjojects.trekkingwebapp.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rbprjojects.trekkingwebapp.entity.Item;



@Repository
public interface ItemRepository extends CrudRepository <Item, Long> { 
    List<Item> findByName(String name);

    List<Item> findAllByOrderByNameAsc();
    
    List<Item> findAllByOrderByWeightDesc();
    
  

   
}