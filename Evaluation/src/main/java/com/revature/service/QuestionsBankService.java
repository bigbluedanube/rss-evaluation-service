package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.entity.QuestionsBank;
import com.revature.repo.QuestionsBankRepository;
import com.revature.repo.QuizRepository;
import com.revature.repo.SubjectRepository;

@Service
public class QuestionsBankService {
	
	QuestionsBankRepository qbr;
	QuizRepository qr;
	SubjectRepository sr;
	
	@Autowired
	public QuestionsBankService(QuestionsBankRepository qbRepository, QuizRepository qRepository, SubjectRepository sRepository) {
		this.qbr=qbRepository;
		this.qr = qRepository;
		this.sr = sRepository;
	}
	
	public List<QuestionsBank> findAllQuestions(){
		return qbr.findAll();
	}
		
	public List<QuestionsBank> findQuestionsByQuiz(QuestionsBank qb){
		qb.setQuiz(qr.findById(qb.getQuizId()).get());
		return qbr.findQuestionsByQuiz(qb.getQuiz());
		
	}
		
	public QuestionsBank InsertQuestion(QuestionsBank qb) {
		qb.setQuiz(qr.findById(qb.getQuizId()).get()); 
			return qbr.save(qb);
	}
	

}
