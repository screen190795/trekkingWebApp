package com.rbprjojects.trekkingwebapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rbprjojects.trekkingwebapp.entity.Route;



@Repository
public interface RouteRepository extends CrudRepository <Route, Long> { 
    List<Route> findByName(String name); 
   
}