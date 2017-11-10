package com.project.employees.models;

import java.util.Date;
import java.util.List;

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
public class Employee{
	
	@Id
	@GeneratedValue
	private long id;
	
	@Size(min=3)
	private String first_name;
	
	@Size(min=3)
	private String last_name;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager")
    private Employee manager;
    
    @OneToMany(mappedBy="manager", fetch = FetchType.LAZY)
    private List<Employee> employees;
    
    private boolean promoted;
	
	@DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
	private Date createdAt;
	
	@DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
	private Date updatedAt;

	@PrePersist
	public void onCreate(){this.createdAt = new Date();}
	@PreUpdate
	public void onUpdate(){this.updatedAt = new Date();}

	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	public Employee getManager() {
		return manager;
	}
	public void setManager(Employee manager) {
		this.manager = manager;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
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

	public Employee(){}
	
	public Employee(String first_name, String last_name){
		this.first_name = first_name;
		this.last_name = last_name;
		this.setPromoted(false);
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}
	public boolean isPromoted() {
		return promoted;
	}
	public void setPromoted(boolean promoted) {
		this.promoted = promoted;
	}
	
}
