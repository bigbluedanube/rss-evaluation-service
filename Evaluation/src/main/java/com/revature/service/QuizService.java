package com.revature.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.entity.Quiz;
import com.revature.entity.Subject;
import com.revature.repo.QuizRepository;
import com.revature.repo.SubjectRepository;


@Service
public class QuizService {
	
	QuizRepository qr;
	
	@Autowired
	public QuizService(QuizRepository qRepository) {
		this.qr = qRepository;
	}

	public List<Quiz> quizList() {
		return this.qr.findAll();
	}
	
	public List<Quiz> findQuizBySubjectId(long subjectId) {
		return this.qr.findQuizBySubjectId(subjectId);
	}
	
	public Optional<Quiz> findById(Long quizId) {
		return this.qr.findById(quizId);
	}

	public Quiz insertQuiz(Quiz q) {
		return this.qr.save(q);
	}

	public String deleteQuizById(Long id) {
		this.qr.deleteById(id);
		return "{'message':'Quiz deleted successfully'}";
	}
	
	public List<Quiz> getAllQuizzes(){
		return this.qr.findAll();
	}
	
}

