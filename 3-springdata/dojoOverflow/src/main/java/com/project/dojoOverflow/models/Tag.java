package com.project.dojoOverflow.models;

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

@Entity
public class Tag {
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
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
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	@Id
	@GeneratedValue
	private Long id;
	
	private String subject;
	
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;	
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name = "QT",
		joinColumns = @JoinColumn(name = "tid"),
		inverseJoinColumns = @JoinColumn(name = "qid"))
	private List<Question> questions;
	
	@PrePersist
	void createdAt() {
		this.createdAt = new Date();
	}
	@PreUpdate
	void updatedAt() {
		this.updatedAt = new Date();
	}
	
	public Tag(String subject){
		this.subject = subject;
	}
	public Tag() {}
	
}
