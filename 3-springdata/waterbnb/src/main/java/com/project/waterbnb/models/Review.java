package com.project.waterbnb.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Review{

	@Id @GeneratedValue
	private Long id;

	@Size(min=20, message="Review must be at least 20 characters.")
	private String details;
	private int rating;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="author")
	private User author;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="pool")
	private Pool pool;
	
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

	public Review(){
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}
	
	public String getDetails() {
		return details;
	}
	public int getRating() {
		return rating;
	}
	public User getAuthor() {
		return author;
	}
	public Pool getPool() {
		return pool;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	public void setPool(Pool pool) {
		this.pool = pool;
	}
}
