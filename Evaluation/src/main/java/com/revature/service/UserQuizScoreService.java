package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.entity.UserQuizScore;
import com.revature.repo.QuizRepository;
import com.revature.repo.UserQuizScoreRepository;

@Service
public class UserQuizScoreService {

	UserQuizScoreRepository uqsr;
	
	@Autowired
	public UserQuizScoreService(UserQuizScoreRepository uqsRepository) {
		this.uqsr=uqsRepository;
	}
	
	public UserQuizScore InsertUserQuizScore(UserQuizScore uqs) {
		return uqsr.save(uqs);
	}
		
	public List<UserQuizScore> getUserQuizScoreByUserId(long userId) {
	
		return uqsr.findUserQuizScoreByUserId(userId);
		
	}
	
}
