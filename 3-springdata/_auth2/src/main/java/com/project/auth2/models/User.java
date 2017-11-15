package com.project.auth.models;

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
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
public class User {

	@Id @GeneratedValue
	private Long id;
	@Size(min=5)
	private String username;
	@Email // to validate format
	@Size(min=5)
	private String email;
	@Size(min=5)
	private String password;
	@Size(min=3)
	private String first;
	@Size(min=3)
	private String last;
	@Transient
	private String passwordConfirmation;
	private int level;
	private Date lastLogin;
	
	public User(){}
	@DateTimeFormat(pattern="MM-dd-yyyy HH:mm:ss")
	@Column(updatable=false)
	private Date createdAt;
	@DateTimeFormat(pattern="MM-dd-yyyy HH:mm:ss")
	private Date updatedAt;
	@PrePersist public void onCreate(){this.createdAt = new Date();}
	@PreUpdate public void onUpdate(){this.updatedAt = new Date();}
	public long getId() {return id;}
	public void setId(long id) {this.id = id;}
	public Date getCreatedAt() {return createdAt;}
	public void setCreatedAt(Date createdAt) {this.createdAt = createdAt;}
	public Date getUpdatedAt() {return updatedAt;}
	public void setUpdatedAt(Date updatedAt) {this.updatedAt = updatedAt;}
	
}
