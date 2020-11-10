package com.rbprjojects.trekkingwebapp.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
public class EquipmentType {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@NotBlank(message = "Name is mandatory")
	@Column(name="Name", length = 128)
	private String name;

	@Column(name="MaxWeight")
	private Float maxWeight;

	@Column(name="MaxVolume")
	private Float maxVolume;

	@Column(name="Description", length =128)
	private String description;


	@ElementCollection
	private Set<Item> items = new HashSet<Item>(0);

	public EquipmentType() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(Float maxWeight) {
		this.maxWeight = maxWeight;
	}

	public Float getMaxVolume() {
		return maxVolume;
	}

	public void setMaxVolume(Float maxVolume) {
		this.maxVolume = maxVolume;
	}

	@Override
	public String toString() {
		return "EquipmentType [id=" + id + ", name=" + name + ", maxWeight=" + maxWeight + ", maxVolume=" + maxVolume
				+ ", description=" + description + "]";
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean hasItem(Item item) {
		for (Item equipmentTypeItem: getItems()) {
			if (equipmentTypeItem.getId() == item.getId()) {
				return true;
			}
		}
		return false;
	}

	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "equipmentType_item", joinColumns = { @JoinColumn(name = "id") }, inverseJoinColumns = { @JoinColumn(name = "id") })
	public Set<Item> getItems() {
		return this.items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}


}
