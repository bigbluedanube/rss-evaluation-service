package com.revature.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name="USER_QUIZ_SCORE")
public class UserQuizScore {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator="USER_QUIZ_SEQ")
	@Column(name="USER_SCORE_ID")
	private long userScoreId;
	
	@Column(name="USER_ID", nullable=false)
	private long userId;
	
	@Column(name="USER_SCORE", nullable=false)
	private int userScore;
	
	@Column(name="SUBMIT_DATE")
	private java.sql.Timestamp submitDate;
	
    @Column(name = "QUIZ_ID")
    private long quizId;
    
    @PrePersist
    protected void prePersist() {
        if (this.submitDate == null) {
        	long millis = System.currentTimeMillis();
        	java.sql.Timestamp ts = new java.sql.Timestamp(millis);
        	this.submitDate = ts;
        }
    }

	public UserQuizScore() {
		super();
	}

	public UserQuizScore(long userId, int userScore, Timestamp submitDate, long quizId) {
		super();
		this.userId = userId;
		this.userScore = userScore;
		this.submitDate = submitDate;
		this.quizId = quizId;
	}

	public long getUserScoreId() {
		return userScoreId;
	}

	public void setUserScoreId(long userScoreId) {
		this.userScoreId = userScoreId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public int getUserScore() {
		return userScore;
	}

	public void setUserScore(int userScore) {
		this.userScore = userScore;
	}

	public java.sql.Timestamp getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(java.sql.Timestamp submitDate) {
		this.submitDate = submitDate;
	}

	public long getQuizId() {
		return quizId;
	}

	public void setQuizId(long quizId) {
		this.quizId = quizId;
	}

	@Override
	public String toString() {
		return "UserQuizScore [userScoreId=" + userScoreId + ", userId=" + userId + ", userScore=" + userScore
				+ ", submitDate=" + submitDate + ", quizId=" + quizId + "]";
	}




}
