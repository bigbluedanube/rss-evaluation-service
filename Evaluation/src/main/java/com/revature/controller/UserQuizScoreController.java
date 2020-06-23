package com.revature.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entity.UserQuizScore;
import com.revature.service.UserQuizScoreService;

@RestController
@RequestMapping(value="/userscore")
public class UserQuizScoreController {
	
	@Autowired
	UserQuizScoreService uqss;
	
	@RequestMapping(value = "/takenquiz", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody()
    public List<UserQuizScore> findUserQuizScoreByUserId(@RequestBody UserQuizScore uqs) {
		return this.uqss.getUserQuizScoreByUserId(uqs.getUserId());
	}
	
	@RequestMapping(value = "/submitquiz", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody()
	public List<String> submitQuiz(@RequestBody UserQuizScore uqs) {
		this.uqss.InsertUserQuizScore(uqs);
		List<String> tmp = new ArrayList<String>();
		tmp.add("Successfully submitted quiz.");
		return tmp;
	}
}
