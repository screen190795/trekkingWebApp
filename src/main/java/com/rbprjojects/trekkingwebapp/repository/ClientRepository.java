
  package com.rbprjojects.trekkingwebapp.repository;
  
  
  
  import org.springframework.data.repository.CrudRepository; import
  org.springframework.stereotype.Repository;
  
  import com.rbprjojects.trekkingwebapp.entity.Client;
  
  
  
  @Repository public interface ClientRepository extends CrudRepository <Client,
  Long> {  }
 