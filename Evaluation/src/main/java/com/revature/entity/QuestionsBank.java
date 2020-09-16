//This is a questionBank entity which going to make QUESTIONS_BANK table in database and create Many-to-One relationship with QUIZZES table.
package com.revature.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Set;

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

	@Column(name="CORRECT_ANSWER", nullable=false)
	private String correctAnswer;

	//We create one transient field for quizId.
	//It will take input from front-end and do the rest of the process which help to maintain relationship with QUIZZES table.
	private transient Long quizId;

	//We create unidirectional Many-To-One relationship from QUESTIONS_BANK table to QUIZZES table where quiz_id is a foreign key in QUESTIONS_BANK table
	@ManyToOne
	@JoinColumn(name = "QUIZ_ID")
	private Quiz quiz;

	@OneToMany(mappedBy="questionId")
	@JsonProperty("options")
	private Set<OptionsBank> options;

	public Set<OptionsBank> getOptions() {
		return options;
	}

	public void setOptions(Set<OptionsBank> options) {
		this.options = options;
	}

	public QuestionsBank() {
		super();
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

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	public Long getQuizId() {
		return quizId;
	}

	public void setQuizId(Long quizId) {
		this.quizId = quizId;
	}

	@Override
	public String toString() {
		return "QuestionsBank{" +
				"questionId=" + questionId +
				", questionValue=" + questionValue +
				", question='" + question + '\'' +
				", correctAnswer='" + correctAnswer + '\'' +
				", quizId=" + quizId +
				", quiz=" + quiz +
				'}';
	}

	//	@Override
//	public String toString() {
//		return "QuestionsBank [questionId=" + questionId + ", questionValue=" + questionValue + ", question=" + question
//				+ ", option1=" + option1 + ", option2=" + option2 + ", option3=" + option3 + ", option4=" + option4
//				+ ", option5=" + option5 + ", correctAnswer=" + correctAnswer + ", quiz=" + quizId + "]";
//	}

}


