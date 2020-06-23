package com.revature.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="QUESTIONS_BANK")
public class QuestionsBank {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="QUESTIONS_BANK_SEQ")
	@Column(name="QUESTION_ID")
	private long questionId;
	
	@Column(name="QUESTION_VALUE", nullable=false)
	private int questionValue;
	
	@Column(name="QUESTION", nullable=false)
	private String question;
	
	@Column(name="Option_1", nullable=false)
	private String option1;
	
	@Column(name="Option_2", nullable=false)
	private String option2;
	
	@Column(name="Option_3", nullable=true)
	private String option3;
	
	@Column(name="Option_4", nullable=true)
	private String option4;
	
	@Column(name="Option_5", nullable=true)
	private String option5;
	
	@Column(name="CORRECT_ANSWER", nullable=false)
	private String correctAnswer;
		
    @Column(name = "QUIZ_ID")
    private long quizId;

	public QuestionsBank() {
		super();
	}



	public QuestionsBank(int questionValue, String question, String option1, String option2, String option3,
			String option4, String option5, String correctAnswer, long quizId) {
		super();
		this.questionValue = questionValue;
		this.question = question;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.option5 = option5;
		this.correctAnswer = correctAnswer;
		this.quizId = quizId;
	}



	public long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}

	public int getQuestionValue() {
		return questionValue;
	}

	public void setQuestionValue(int questionValue) {
		this.questionValue = questionValue;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public String getOption5() {
		return option5;
	}

	public void setOption5(String option5) {
		this.option5 = option5;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public long getQuizId() {
		return quizId;
	}

	public void setQuizId(long quizId) {
		this.quizId = quizId;
	}

	@Override
	public String toString() {
		return "QuestionsBank [questionId=" + questionId + ", questionValue=" + questionValue + ", question=" + question
				+ ", option1=" + option1 + ", option2=" + option2 + ", option3=" + option3 + ", option4=" + option4
				+ ", option5=" + option5 + ", correctAnswer=" + correctAnswer + ", quizId=" + quizId + "]";
	}
	


}


