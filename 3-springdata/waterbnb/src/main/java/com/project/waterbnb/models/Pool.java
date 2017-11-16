package com.project.waterbnb.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Pool{

	@Id @GeneratedValue
	private Long id;

	@Size(min=1)
	private String location;
	@Size(min=1)
	private String description;
	@Size(min=1)
	private String size;
	private int cost;
	private int avgRating;
	
	@OneToMany(mappedBy="pool", fetch=FetchType.LAZY)
	private List<Review> reviews;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="host")
	private User host;
	
	@DateTimeFormat(pattern="MM-dd-yyyy HH:mm:ss")
	@Column(updatable=false)
	private Date createdAt;
	@DateTimeFormat(pattern="MM-dd-yyyy HH:mm:ss")
	private Date updatedAt;
	@PrePersist public void onCreate(){this.createdAt = new Date();}
	@PreUpdate public void onUpdate(){this.updatedAt = new Date();}
	public Long getId() {return id;}
	public void setId(Long id) {this.id = id;}
	public Date getCreatedAt() {return createdAt;}
	public void setCreatedAt(Date createdAt) {this.createdAt = createdAt;}
	public Date getUpdatedAt() {return updatedAt;}
	public void setUpdatedAt(Date updatedAt) {this.updatedAt = updatedAt;}

	public Pool(){
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}
	
	public String getLocation() {
		return location;
	}
	public String getDescription() {
		return description;
	}
	public int getAvgRating() {
		return avgRating;
	}
	public List<Review> getReview() {
		return reviews;
	}
	public User getHost() {
		return host;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setAvgRating(int avgRating) {
		this.avgRating = avgRating;
	}
	public void setReview(List<Review> reviews) {
		this.reviews = reviews;
	}
	public void setHost(User host) {
		this.host = host;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
}
