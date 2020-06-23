package com.revature.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entity.Quiz;
import com.revature.entity.Subject;
import com.revature.service.QuizService;
import com.revature.util.LogThis;

@RestController
@RequestMapping(value="/quiz")
public class QuizController {
	
	@Autowired
	QuizService qs;
	
	@RequestMapping(value = "/addquiz", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody()
	public Quiz insertQuiz (@RequestBody Quiz q) {
		//Log4j
		LogThis.LogIt("info","Quiz added"+" "+q.getQuizTopic());
		System.out.println(q);
		return this.qs.insertQuiz(q);
	}
	
	@RequestMapping(value = "/findbyid", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody()
	public Optional<Quiz> findQuizById (@RequestBody Quiz q) {
		
		return this.qs.findById(q.getQuizId());

	}
	
	@RequestMapping(value = "/findbysubject", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody()
	public List<Quiz> findQuizBySubjectId (@RequestBody Quiz q) {
		
		return this.qs.findQuizBySubjectId(q.getSubjectId());
		
	}
	
	@RequestMapping(value = "/getallquizzes", method = RequestMethod.GET)
	@ResponseBody()
	public List<Quiz> getAllQuizzes(){
		return this.qs.getAllQuizzes();
	}
}
