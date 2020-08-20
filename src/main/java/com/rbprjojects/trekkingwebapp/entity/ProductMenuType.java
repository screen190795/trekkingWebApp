package com.rbprjojects.trekkingwebapp.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class ProductMenuType {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotBlank(message = "Product Menu Type Name is mandatory")
	@Column(name="Name", length = 128,nullable = false)
	private String name;
	
	@Column(name="MaxWeight")
	private Float maxWeight;
	
	@Column(name="MinProteins")
	private Integer minProteins;
	
	@Column(name="MinFats")
	private Integer minFats;
	
	@Column(name="MinCarbohydrates")
	private Integer minCarbohydrates;
	
	@Column(name="Description", length =128)
	private String description;

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

	public Integer getMinProteins() {
		return minProteins;
	}

	public void setMinProteins(Integer minProteins) {
		this.minProteins = minProteins;
	}

	public Integer getMinFats() {
		return minFats;
	}

	public void setMinFats(Integer minFats) {
		this.minFats = minFats;
	}

	public Integer getMinCarbohydrates() {
		return minCarbohydrates;
	}

	public void setMinCarbohydrates(Integer minCarbohydrates) {
		this.minCarbohydrates = minCarbohydrates;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ProductMenuType [id=" + id + ", name=" + name + ", maxWeight=" + maxWeight + ", minProteins="
				+ minProteins + ", minFats=" + minFats + ", minCarbohydrates=" + minCarbohydrates + ", description="
				+ description + "]";
	}

	public ProductMenuType() {
	
	}
	@ManyToMany(mappedBy = "productMenuTypes")
    private Set<Product> products;
	
}
