package com.rbprjojects.trekkingwebapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rbprjojects.trekkingwebapp.entity.EquipmentType;



@Repository
public interface EquipmentTypeRepository extends CrudRepository <EquipmentType, Long> { 
    List<EquipmentType> findByName(String name);
    Optional<EquipmentType> findById(Long id);
	
		
	

	 
   
}