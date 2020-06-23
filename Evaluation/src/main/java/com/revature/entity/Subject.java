package com.revature.entity;

//import java.util.List;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="SUBJECTS")
public class Subject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator="SUBJECT_SEQ")
	@Column(name="SUBJECT_ID")
	private long subjectId;
	
	@Column(name="SUBJECT_NAME", unique=true)
	private String subjectName;
	
	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Subject(long subjectId, String subjectName) {
		super();
		this.subjectId = subjectId;
		this.subjectName = subjectName;
	}

	public long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

//	public List<Quiz> getQuizList() {
//		return quizList;
//	}
//
//	public void setQuizList(List<Quiz> quizList) {
//		this.quizList = quizList;
//	}

	@Override
	public String toString() {
		return "Subject [subjectId=" + subjectId + ", subjectName=" + subjectName + "]";
	}
	
}
