package com.codingdojo.languages.models;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="languages")
public class Language {

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
	@Size(min = 2, max = 20, message="Please enter a language from 2 to 20 characters.")
    private String name;
    
	@NotNull
    @Size(min = 2, max = 20, message="Please enter a name from 2 to 20 characters.")
    private String creator;
    
	@NotNull
    @Size(min = 1, message="Please fill out this field.")
    private String currentVersion;
	
	public Language() {
		this.createdAt = new Date();
		this.updatedAt = new Date();
    }
    
    public Language(String name, String creator, String currentVersion, Long id) {
        this.id = id;
    		this.name = name;
        this.creator = creator;
        this.currentVersion = currentVersion;
        this.createdAt = new Date();
		this.updatedAt = new Date();
    }
	
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getCurrentVersion() {
		return currentVersion;
	}

	public void setCurrentVersion(String currentVersion) {
		this.currentVersion = currentVersion;
	}
    
}
