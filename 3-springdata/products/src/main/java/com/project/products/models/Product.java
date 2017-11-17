package com.project.products.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Product {

	@Id
	@GeneratedValue
	@JsonProperty("id")
	private Long id;
	
	@NotNull(message="Please enter a product.")
	@JsonProperty("name")
	private String name;

	@NotNull(message="Please add a description.")
	@JsonProperty("description")
	private String description;

	@NumberFormat(style=Style.CURRENCY)
	@JsonProperty("price")
	private float price;
	
	@Column(updatable=false)
	@JsonProperty("posted")
	private Date createdAt;
	private Date updatedAt;
	
    @PrePersist
    public void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    public void onUpdate(){
        this.updatedAt = new Date();
    }
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
		name="bridge",
		joinColumns = @JoinColumn(name = "product_id"),
		inverseJoinColumns = @JoinColumn(name = "category_id"))
	private List<Category> categories;
	
	public Product(){
	}
	public Long getId() {
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
}
