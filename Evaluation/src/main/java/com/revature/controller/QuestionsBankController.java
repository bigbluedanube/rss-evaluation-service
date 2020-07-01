package com.revature.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.revature.beans.Account;
import com.revature.beans.Question;
import com.revature.beans.Result;
import com.revature.entity.QuestionsBank;
import com.revature.entity.UserQuizScore;
import com.revature.service.QuestionsBankService;
import com.revature.service.UserQuizScoreService;

import com.revature.util.LogThis;


@RestController
@RequestMapping(value="/question")
public class QuestionsBankController {
	
	QuestionsBankService qbs;
	UserQuizScoreService uqss;
	
	//We use constructor auto-wiring to auto-wired multiple services.
	@Autowired
	public QuestionsBankController(QuestionsBankService qbService, UserQuizScoreService uqsService) {
		this.qbs=qbService;
		this.uqss=uqsService;
	}

	//Change endpoint from /add to /admin/add
	 @RequestMapping(value = "/admin/add", method = RequestMethod.POST,
	            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	    @ResponseBody()
	    public QuestionsBank insertQuestion (@RequestBody QuestionsBank qb) {
	    	//Log4j
	    	LogThis.LogIt("info","Question added");
			return this.qbs.InsertQuestion(qb);
	 	}
	 
	 //Change endpoint from /delete to /admin/delete
	 @RequestMapping(value = "/admin/delete", method = RequestMethod.POST,
	            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

	    @ResponseBody()
	    public List<String> deleteQuestion (@RequestBody QuestionsBank qb) {
	    	//Log4j
	    	LogThis.LogIt("info","Question deleted");
			return this.qbs.deleteQuestion(qb.getQuestionId());
	 	}
	 
	 	//Change endpoint from /addall to /admin/addall
		@RequestMapping(value = "/admin/addall", method = RequestMethod.POST,
	            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	    @ResponseBody()
	    public List<QuestionsBank> insertAllQuestions (@RequestBody List<QuestionsBank> qbList) {
	    	List<QuestionsBank> qbList1 = new ArrayList<QuestionsBank>();
	    	for (int i = 0; i < qbList.size(); i++) {
	    		qbList1.add(qbs.InsertQuestion(qbList.get(i)));
	    	}
	    	//Log4j
	    	LogThis.LogIt("info","Multiple Question added");
	    	return qbList1;
			
		}
		
		//change endpoint from /submitQuiz to /forward
		@RequestMapping(value = "/forward", method = RequestMethod.POST,
	            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	    @ResponseBody()
	    public Result calculatePoints (@RequestBody List<Question> qList) {
	    	QuestionsBank qb = null;
	    	UserQuizScore uqs = new UserQuizScore();
	    	Result result = new Result();
	    	String userEmail = null;
	    	
	    	int accId = 0;
	    	long quizId = 0;
	    	int correctAnswers = 0;
	    	int totalPoints = 0;
	    	int totalQuestions =qList.size();
	    	Date date = new Date();
	    	
	    	for (int i = 0; i < qList.size(); i++) {
	    		
	    		qb = new QuestionsBank();
	    		qb=(qbs.getQuestion(qList.get(i).getQuestionId()));
	    		System.out.println(qb);
	    		userEmail = qList.get(i).getUserEmail();
	    		accId = qList.get(i).getAcctId();
	    		quizId = qb.getQuiz().getQuizId();
	    		
	    		if(qList.get(i).getSelectedAnswer().equalsIgnoreCase(qb.getCorrectAnswer())){
	    			totalPoints += qb.getQuestionValue();
	    			System.out.println(qList.get(i).getQuestionValue());
	    			correctAnswers++;
	    		}
	    	}
	    	qb.setQuizId(quizId);
	    	totalQuestions=qbs.findQuestionsByQuiz(qb).size();
	    	System.out.println(totalQuestions);
	    	uqs.setSubmitDate(date);
	    	uqs.setUserEmail(userEmail);
	    	uqs.setQuizId(quizId);
	    	uqs.setUserScore(totalPoints);
	    	
	    	uqss.InsertUserQuizScore(uqs);
	    	
	    	result.setTotalQuestions(totalQuestions);
	    	result.setCorrectAnswers(correctAnswers);
	    	result.setTotalPoints(totalPoints);
	    	
	    	Account acc = new Account();
	    	
	    	acc.setAccId(accId);
	    	acc.setPoints(totalPoints);
	    	
	    	//create uri string
	    	String uri = "http://localhost:9000/account/points/a";
	    	
	    	// Create a new RestTemplate instance
	    	RestTemplate restTemplate = new RestTemplate();

	    	// Add the Jackson and String message converters
	    	restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
	    	restTemplate.getMessageConverters().add(new StringHttpMessageConverter());

	    	// Make the HTTP POST request, marshaling the request to JSON, and the response to a String
	    	String response = restTemplate.postForObject(uri, acc, String.class);
	    	System.out.println(response);
	    	
	    	return result;
		}
	    
		//change endpoint from /getquestions to /questions
		@RequestMapping(value = "/questions", method = RequestMethod.POST,
	            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	    @ResponseBody()
	    public List<Question> getQuestionsByQuizId (@RequestBody QuestionsBank qb) {
			
	    	List<QuestionsBank> qbList;
			List<Question> qList= new ArrayList<Question>();
			Question q = null;
			
	    	qbList = this.qbs.findQuestionsByQuiz(qb);
	    	
	    	for (int i = 0; i < qbList.size(); i++) {
	    		q = new Question();
			    q.setQuestionId(qbList.get(i).getQuestionId());
			    q.setQuestionValue(qbList.get(i).getQuestionValue());
			    q.setQuestion(qbList.get(i).getQuestion());
			    q.setOption1(qbList.get(i).getOption1());
			    q.setOption2(qbList.get(i).getOption2());
			    q.setOption3(qbList.get(i).getOption3());
			    q.setOption4(qbList.get(i).getOption4());
			    q.setOption5(qbList.get(i).getOption5());
			    qList.add(q);
			}
			return qList;
			
		}
		
		//change endpoint from /getquestionsadmin to /admin/questions
		@RequestMapping(value = "/admin/questions", method = RequestMethod.POST,
	            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	    @ResponseBody()
	    public List<QuestionsBank> getQuestionsByQuizIdAdmin (@RequestBody QuestionsBank qb) {
	    
			return this.qbs.findQuestionsByQuiz(qb);
			
		}
}
