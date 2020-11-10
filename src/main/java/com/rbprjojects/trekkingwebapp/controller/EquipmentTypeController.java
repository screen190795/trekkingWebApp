package com.rbprjojects.trekkingwebapp.controller;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.rbprjojects.trekkingwebapp.entity.EquipmentType;
import com.rbprjojects.trekkingwebapp.entity.Item;
import com.rbprjojects.trekkingwebapp.repository.EquipmentTypeRepository;
import com.rbprjojects.trekkingwebapp.repository.ItemRepository;




@Controller
@RequestMapping("/equipmentTypes/")
public class EquipmentTypeController {
	
	
	
	@Autowired
    private EquipmentTypeRepository equipmentTypeRepository; 

	@Autowired
    private ItemRepository itemRepository; 
	
	

	@GetMapping("equipmentTypes-list")
	public String getEquipmentTypessList() {
		return "equipmentTypes-list.html";
	}
				
	@GetMapping("list")
	public String showUpdateForm(Model model) {
		model.addAttribute("equipmentTypes", equipmentTypeRepository.findAll());
		return "equipmentTypes-list";
	}
	
	@RequestMapping("/equipment")
	public String index(Model model) {
		List<EquipmentType> equipmentTypes = (List<EquipmentType>) equipmentTypeRepository.findAll();
		model.addAttribute("equipmentTypes", equipmentTypes);
    	return "equipment";
    }
	
	@GetMapping("add")
	public String showAddForm(EquipmentType equipmentType) {
		return "add-equipmentType";
	}


	@PostMapping("add")
	public String addEquipmentType(@Valid EquipmentType equipmentType, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-eqipmentType";
		}

		equipmentTypeRepository.save(equipmentType);
		return "redirect:list";
	}

	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		EquipmentType equipmentType = equipmentTypeRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid equipmentType Id:" + id));
		model.addAttribute("equipmentType", equipmentType);
		return "update-equipmentType";
	}

	@PostMapping("update/{id}")
	public String updateEquipmetType(@PathVariable("id") long id, @Valid EquipmentType equipmentType, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			equipmentType.setId(id);
			return "update-equipmentType";
		}

		equipmentTypeRepository.save(equipmentType);
		model.addAttribute("equipmentTypes", equipmentTypeRepository.findAll());
		return "equipmentTypes-list";
	}

	@GetMapping("delete/{id}")
	public String deleteEquipmentType(@PathVariable("id") long id, Model model) {
		EquipmentType equipmentType = equipmentTypeRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid equipmentType Id:" + id));
		equipmentTypeRepository.delete(equipmentType);
		model.addAttribute("equipmentTypes", equipmentTypeRepository.findAll());
		return "equipmentTypes-list";
	}
	

	
	
	
	
	  @RequestMapping(value = "get/{id}")
	    public String getEquipmentTypeId(@PathVariable("id") Long equipmentTypeId,
	                               Model model){

		    Optional<EquipmentType> optionalEquipmentType = equipmentTypeRepository.findById(equipmentTypeId);
		    EquipmentType equipmentType = optionalEquipmentType.get();
	        model.addAttribute("items", itemRepository.findAll());
	        model.addAttribute("equipmentType",equipmentType);

	       return "addEquipmentTypeItem";
	    }

	  @RequestMapping(value = "/addItemEquipmentType/{id}/item")
	    public String addCourseStudent(@PathVariable("id") Long equipmentTypeId,
	                                   @RequestParam("itemId") Long itemId){

	        Optional<Item> optionalItem = itemRepository.findById(itemId);
	        Optional<EquipmentType> optionalEquipmentType = equipmentTypeRepository.findById(equipmentTypeId);
	        
	        if (optionalEquipmentType.isPresent()) {
	            EquipmentType equipmentType = optionalEquipmentType.get();
	            if (optionalItem.isPresent()) {
		            Item item = optionalItem.get();
	            
	        if (equipmentType!=null){
	            equipmentType.getItems().add(item);

	           equipmentTypeRepository.save(equipmentType);
	        }
	        }
	        }
	        return "equipmentTypes-list";    
    
		
		
	        } 
}
	
	

	
	
	
	

