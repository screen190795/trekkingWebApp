package com.rbprjojects.trekkingwebapp.entity;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;
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
	@ManyToMany(mappedBy = "items")
	@ElementCollection
	private Set<EquipmentType> equipmentTypes;

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


	public Set<EquipmentType> getEquipmentTypes() {
		return equipmentTypes;
	}
	public void setEquipmentTypes(Set<EquipmentType> equipmentTypes) {
		this.equipmentTypes = equipmentTypes;
	}


}
