package com.rbprjojects.trekkingwebapp.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@NotBlank(message = "Product Name is mandatory")
	@Column(name="Name", length = 128,nullable = false)
	private String name;

	@Column(name="Weight")
	private Float weight;

	@Column(name="Proteins")
	private Integer proteins;

	@Column(name="Fats")
	private Integer fats;

	@Column(name="Carbohydrates")
	private Integer carbohydrates;

	@Column(name="Description", length =128)
	private String description;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable
	private Set<ProductMenuType> productMenuTypes;

	public Product() {

	}

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

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public Integer getProteins() {
		return proteins;
	}

	public void setProteins(Integer proteins) {
		this.proteins = proteins;
	}

	public Integer getFats() {
		return fats;
	}

	public void setFats(Integer fats) {
		this.fats = fats;
	}

	public Integer getCarbohydrates() {
		return carbohydrates;
	}

	public void setCarbohydrates(Integer carbohydrates) {
		this.carbohydrates = carbohydrates;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}




}
