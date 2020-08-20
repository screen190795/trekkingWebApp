package com.rbprjojects.trekkingwebapp.entity;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.persistence.Table;
@Table
@Entity

public class Item {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotBlank(message = "Name is mandatory")
	@Column(name="Name", length = 128,nullable = false)
	private String name;
	
	@Column(name="Weight")
	private Float weight;

	@Column(name="Volume")
	private Float volume;
	
	@Column(name="Description", length =128)
	private String description;
	
	public Item() {}
	
	public long getId() {
		return id;
	}
	public void setId(Long id) {
        this.id = id;
        
    }
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public Float getVolume() {
		return volume;
	}

	public void setVolume(Float volume) {
		this.volume = volume;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", weight=" + weight + ", volume=" + volume + ", description="
				+ description + "]";
	}

	@ManyToMany(mappedBy = "items")   
	@ElementCollection
	private Set<EquipmentType> equipmentTypes;  
	    
	public Set<EquipmentType> getEquipmentTypes() {
	    return equipmentTypes;
	}
	 public void setEquipmentTypes(Set<EquipmentType> equipmentTypes) {
	        this.equipmentTypes = equipmentTypes;
	    }
	
	 
}
