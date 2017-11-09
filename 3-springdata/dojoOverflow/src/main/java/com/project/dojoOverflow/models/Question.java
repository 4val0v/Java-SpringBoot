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
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Question {

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
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
	public List<Tag> getTags() {
		return tags;
	}
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull(message="Please enter a question.")
	private String question;
	
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name = "QT",
		joinColumns = @JoinColumn(name = "qid"),
		inverseJoinColumns = @JoinColumn(name = "tid"))
	@Size(max=3, message="Cannot have more than 3 tags")
	private List<Tag> tags;
	
	@OneToMany(mappedBy="question", fetch=FetchType.LAZY)
	private List<Answer> answers;
	
	@PrePersist
	void createdAt() {
		this.createdAt = new Date();
	}
	@PreUpdate
	void updatedAt() {
		this.updatedAt = new Date();
	}
	
	public Question(){}
	
	public Question(String question, List<Tag> tags){
		this.question = question;
		this.tags = tags;
	}
	
	
}
