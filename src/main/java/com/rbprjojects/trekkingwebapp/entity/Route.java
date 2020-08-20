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
public class Route {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotBlank(message = "Name is mandatory")
	@Column(name="Name", length = 128,nullable = false)
	private String name;
	
	@Column(name="StartX")
	private Double startX;

	@Column(name="StartY")
	private Double startY;
	
	@Column(name="FinishX")
	private Double finishX;
	
	@Column(name="FinishY")
	private Double finishY;
	
	@Column(name="Length")
	private Integer length;
	
	@Column(name="Duration")
	private Float duration;
	
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

	public Double getStartX() {
		return startX;
	}

	public void setStartX(Double startX) {
		this.startX = startX;
	}

	public Double getStartY() {
		return startY;
	}

	public void setStartY(Double startY) {
		this.startY = startY;
	}

	public Double getFinishX() {
		return finishX;
	}

	public void setFinishX(Double finishX) {
		this.finishX = finishX;
	}

	public Double getFinishY() {
		return finishY;
	}

	public void setFinishY(Double finishY) {
		this.finishY = finishY;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public Float getDuration() {
		return duration;
	}

	public void setDuration(Float duration) {
		this.duration = duration;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Route [id=" + id + ", name=" + name + ", startX=" + startX + ", startY=" + startY + ", finishX="
				+ finishX + ", finishY=" + finishY + ", length=" + length + ", duration=" + duration + ", description="
				+ description + "]";
	}

	public Route() {
	}
	
	 @ManyToMany(mappedBy = "routes")
	    private Set<Client> clients;
	
	
}
