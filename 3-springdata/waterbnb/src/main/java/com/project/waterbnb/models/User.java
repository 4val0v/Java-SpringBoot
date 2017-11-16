package com.project.waterbnb.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class User {

	@Id @GeneratedValue	private Long id;
	@Column(unique=true)
	@Email
	@Size(min=3)			private String username;
	@Size(min=3)			private String password;
	@Transient			private String passwordConfirmation;
	@Email				private String email;
	@Size(min=3)			private String first;
	@Size(min=3)			private String last;
	private Date lastLogin;
	private int level;
	
	@OneToMany(mappedBy="host", fetch=FetchType.LAZY)
	private List<Pool> pools;
	
	@OneToMany(mappedBy="author", fetch=FetchType.LAZY)
	private List<Review> review;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="MM-dd-yyyy HH:mm:ss") private Date createdAt;
	@DateTimeFormat(pattern="MM-dd-yyyy HH:mm:ss") private Date updatedAt;
	@PrePersist public void onCreate(){this.createdAt = new Date();}
	@PreUpdate public void onUpdate(){this.updatedAt = new Date();}
	public Long getId() {return id;}
	public Date getCreatedAt() {return createdAt;}
	public Date getUpdatedAt() {return updatedAt;}
	public void setId(long id) {this.id = id;}
	public void setCreatedAt(Date createdAt) {this.createdAt = createdAt;}
	public void setUpdatedAt(Date updatedAt) {this.updatedAt = updatedAt;}

	public User(){
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}
	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	public Date getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<Pool> getPools() {
		return pools;
	}
	public List<Review> getReview() {
		return review;
	}
	public void setPools(List<Pool> pools) {
		this.pools = pools;
	}
	public void setReview(List<Review> review) {
		this.review = review;
	}
	
}
