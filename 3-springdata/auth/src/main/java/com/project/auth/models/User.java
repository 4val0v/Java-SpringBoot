package com.project.auth.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
	@Size(min=5)			private String username;
	@Size(min=5)			private String password;
	@Transient				private String passwordConfirmation;
	@Email @Size(min=3)		private String email;
	@Size(min=3)			private String first;
	@Size(min=3)			private String last;
	private LocalDateTime lastLogin;
	private int level;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="MM-dd-yyyy HH:mm:ss") private LocalDateTime createdAt;
	@DateTimeFormat(pattern="MM-dd-yyyy HH:mm:ss") private LocalDateTime updatedAt;
	@PrePersist public void onCreate(){this.createdAt = LocalDateTime.now();}
	@PreUpdate public void onUpdate(){this.updatedAt = LocalDateTime.now();}
	public Long getId() {return id;}
	public LocalDateTime getCreatedAt() {return createdAt;}
	public LocalDateTime getUpdatedAt() {return updatedAt;}
	public void setId(Long id) {this.id = id;}
	public void setCreatedAt(LocalDateTime createdAt) {this.createdAt = createdAt;}
	public void setUpdatedAt(LocalDateTime updatedAt) {this.updatedAt = updatedAt;}

	public User(){
		this.createdAt = LocalDateTime.now();
		this.updatedAt = LocalDateTime.now();
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
	public LocalDateTime getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(LocalDateTime lastLogin) {
		this.lastLogin = lastLogin;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
}
