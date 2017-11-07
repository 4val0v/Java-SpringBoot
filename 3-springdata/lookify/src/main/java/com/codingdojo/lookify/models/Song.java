package com.codingdojo.lookify.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Song {

	@Id // sets attribute as primary key
	@GeneratedValue // sets as auto-incrementing value
	private Long id;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	private Date createdAt;
	
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	private Date updatedAt;
	
    @PrePersist
    public void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    public void onUpdate(){
        this.updatedAt = new Date();
    }
	
	@NotNull
	@Size(min = 5, max = 255, message="Title must be at least 5 characters.")
    private String title;
    
	@NotNull
    @Size(min = 5, max = 255, message="Artist must be at least 5 characters.")
    private String artist;
    
	@NotNull
    @Min(value=1, message="Please select a rating between 1 and 10.")
	@Max(value=10, message="Please select a rating between 1 and 10.")
    private int rating;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public Song() {
	}
    
    public Song(Long id, String title, String artist) {
        this.id = id;
    		this.title = title;
        this.artist = artist;
        this.createdAt = new Date();
		this.updatedAt = new Date();
    }
    
}
