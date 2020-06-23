package com.revature.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.entity.QuestionsBank;
import com.revature.repo.QuestionsBankRepository;
import com.revature.repo.QuizRepository;
import com.revature.repo.SubjectRepository;

@Service
public class QuestionsBankService {
	
	
	QuestionsBankRepository qbr;
	
	@Autowired
	public QuestionsBankService(QuestionsBankRepository qbRepository) {
		this.qbr=qbRepository;
	}
	
	public List<QuestionsBank> findAllQuestions(){
		return qbr.findAll();
	}
		
	public List<QuestionsBank> findQuestionsByQuizId(long quizId){
		
		return this.qbr.findQuestionsBankByQuizId(quizId);
	}
	
	public Optional<QuestionsBank> findQuestionsByQuestionId(long questionId){
		return qbr.findById(questionId);
	}
		
	public QuestionsBank InsertQuestion(QuestionsBank qb) { 
		return qbr.save(qb);
	}
	

}
