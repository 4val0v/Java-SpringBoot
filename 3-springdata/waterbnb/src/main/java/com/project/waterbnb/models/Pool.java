package com.project.waterbnb.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Pool{

	@Id @GeneratedValue
	private Long id;

	@Size(min=3, message="Size")
	private String name;

	// Add member variables
	// Don't forget getters and setters
	

	// -- MANY TO MANY --//
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="Join_",
		joinColumns=@JoinColumn(name="many1_id"),
		inverseJoinColumns=@JoinColumn(name="many2_id"))
	private List<Many> many1s;
	// on other side:
	@ManyToMany(mappedBy="many1s", cascade=CascadeType.ALL)
	private List<Many> many2s;
	// -- JOIN CLASS -- // (add to each side)
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="one1_id")
	private One1 one1;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="one2_id")
	private One2 one2;
	// ----------------- //

	// -- ONE TO MANY -- //
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="one_id")
	private One one;
	// on other side:
	@OneToMany(mappedBy="one", fetch=FetchType.LAZY)
	private List<Many> many;
	// ----------------- //

	// -- ONE TO ONE -- //
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="one1_id")
	private One1 one1;
	// on other side:
	@OneToOne(mappedBy=one1, cascade=CascadeType.All, fetch=FetchType.LAZY)
	private One2 one2;
	// ----------------- //
	
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

	public Pool(){}
	public Pool(){
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}
}
