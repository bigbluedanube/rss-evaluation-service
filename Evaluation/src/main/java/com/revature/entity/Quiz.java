package com.revature.entity;

//import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="QUIZZES")
public class Quiz {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator="QUIZ_SEQ")
	@Column(name="QUIZ_ID")
	private long quizId;
	
	@Column(name="QUIZ_TOPIC", nullable=false)
	private String quizTopic;
	
	@Column(name="QUIZ_DESCRIPTION", nullable=true)
	private String quizDescription;
	
	@Column(name="CREATOR_EMAIL", nullable=false)
	private String creatorEmail;
	
		
    @Column(name = "SUBJECT_ID")
    private long subjectId;
	

	public Quiz() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Quiz(String quizTopic, String quizDescription, String creatorEmail, long subjectId) {
		super();
		this.quizTopic = quizTopic;
		this.quizDescription = quizDescription;
		this.creatorEmail = creatorEmail;
		this.subjectId = subjectId;
	}



	public long getQuizId() {
		return quizId;
	}


	public void setQuizId(long quizId) {
		this.quizId = quizId;
	}


	public String getQuizTopic() {
		return quizTopic;
	}


	public void setQuizTopic(String quizTopic) {
		this.quizTopic = quizTopic;
	}


	public String getQuizDescription() {
		return quizDescription;
	}


	public void setQuizDescription(String quizDescription) {
		this.quizDescription = quizDescription;
	}


	public String getCreatorEmail() {
		return creatorEmail;
	}


	public void setCreatorEmail(String creatorEmail) {
		this.creatorEmail = creatorEmail;
	}


	public long getSubjectId() {
		return subjectId;
	}


	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}



	@Override
	public String toString() {
		return "Quiz [quizId=" + quizId + ", quizTopic=" + quizTopic + ", quizDescription=" + quizDescription
				+ ", creatorEmail=" + creatorEmail + ", subjectId=" + subjectId + "]";
	}
	
	
	
}
