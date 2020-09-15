package com.revature.controller;

import java.util.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.entity.*;
import com.revature.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Question;
import com.revature.beans.Result;

import com.revature.util.LogThis;


@RestController
@RequestMapping(value="/question")
public class QuestionsBankController {

//	QuizService qs;
//	SubjectService ss;
	OptionsBankService obs;
	QuestionsBankService qbs;
	UserQuizScoreService uqss;

	//We use constructor auto-wiring to auto-wired multiple services.
	@Autowired
	public QuestionsBankController(/*QuizService qService, SubjectService sService, */OptionsBankService obService, QuestionsBankService qbService, UserQuizScoreService uqsService) {
		this.obs=obService;
		this.qbs=qbService;
		this.uqss=uqsService;
	}

//	//Change endpoint from /add to /admin/add
//	@RequestMapping(value = "/admin/addQuestion", method = RequestMethod.POST,
//			consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//
//	@ResponseBody()
//	public QuestionsBank insertQuestion (@RequestBody QuestionsBank qb) {
//		//Log4j
//		LogThis.LogIt("info","Question added");
//		System.out.println("*****************************");
//		System.out.println(qb.toString());
//		System.out.println("*****************************");
//		return this.qbs.InsertQuestion(qb);
//	}

	//Here we are deconstructing the String Json that comes from the front end that includes the Question along with its options
	//in the format of(Look down). QuestionId's and optionsId's are generated on the back end. so zero is fine as input.
//	{
//		"questionId": 0,
//		"questionValue": 5,
//		"question": "2 + 2 =",
//		"correctAnswer": "4",
//		"quizId": 129,
//		"options":
//    [{
//		"optionId": 0,
//		"option": "22"
//	}, {
//		"optionId": 0,
//		"option": "4"
//	}, {
//		"optionId": 0,
//		"option": "40"
//	}]
//	}
	//Change endpoint from /add to /admin/add
	@RequestMapping(value = "/admin/addQuestion", method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

	@ResponseBody()
	public QuestionsBank insertQuestion (@RequestBody String qb) {
		System.out.println("*****************************");
		System.out.println(qb);
		System.out.println("*****************************");
		ObjectMapper om = new ObjectMapper();
		QuestionsBank q = new QuestionsBank();
		QuestionsBank rtn = new QuestionsBank();
		Set<OptionsBank> optionSet = new HashSet<>();
		try {
			Map<String,Object> check = om.readValue(qb,Map.class);
//			System.out.println("*****************************");
//			System.out.println(check.toString());
//			System.out.println("*****************************");
//			System.out.println(Long.parseLong(check.get("questionId").toString()));
			q.setQuestionId(Long.parseLong(check.get("questionId").toString()));
//			System.out.println("*****************************");
//			System.out.println((int)check.get("questionValue"));
			q.setQuestionValue((int)check.get("questionValue"));
//			System.out.println("*****************************");
//			System.out.println(check.get("question").toString());
			q.setQuestion(check.get("question").toString());
//			System.out.println("*****************************");
//			System.out.println(check.get("correctAnswer").toString());
			q.setCorrectAnswer(check.get("correctAnswer").toString());
//			System.out.println("*****************************");
//			System.out.println(Long.parseLong(check.get("quizId").toString()));
			q.setQuizId(Long.parseLong(check.get("quizId").toString()));
			rtn = qbs.InsertQuestion(q);
//			System.out.println(rtn.toString());
			String options = check.get("options").toString();
			options = options.replace("[{", "");
			options = options.replace("}]", "");
			options = options.replace("{", "");
			String[] optionsArray = options.split("}, ");
			for (int i=0; i<optionsArray.length; i++) {
//				System.out.println("*****************************");
//				System.out.println(optionsArray[i]);
				String[] str = optionsArray[i].split(", ");
				OptionsBank ob = new OptionsBank();
				for (int j=0; j<str.length; j++) {
					if (j==0) {
						str[j] = str[j].replace("optionId=", "");
						ob.setOptionId(Long.parseLong(str[j]));
					} else if (j==1) {
						str[j] = str[j].replace("option=", "");
						ob.setOption(str[j]);
					}
					ob.setQuestionId(rtn.getQuestionId());
				}
				ob.setQuestion(rtn);
				obs.InsertOption(ob);
				optionSet.add(ob);
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		//Log4j
		LogThis.LogIt("info","Question added");
//		rtn.setOptions(optionSet);
		return rtn;
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

		System.out.println("*****************************");
		System.out.println(qbList.toString());
		System.out.println("*****************************");

		List<QuestionsBank> qbList1 = new ArrayList<QuestionsBank>();
		for (int i = 0; i < qbList.size(); i++) {
			qbList1.add(qbs.InsertQuestion(qbList.get(i)));
		}
		//Log4j
		LogThis.LogIt("info","Multiple Question added");
		return qbList1;
	}

//		//Change endpoint from /addall to /admin/addall
//	@RequestMapping(value = "/admin/addall", method = RequestMethod.POST,
//			consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//	@ResponseBody()
//	public List<QuestionsBank> insertAllQuestions (@RequestBody String qbList) {
//
//		System.out.println("*****************************");
//		System.out.println(qbList);
//		System.out.println("*****************************");
//
////		ObjectMapper om = new ObjectMapper();
//
////		qbList = qbList.replace("},", "}");
////		String[] str = qbList.split(" -,- ");
////		System.out.println(str.length);
////		for (int i=0; i<str.length; i++) {
////			System.out.println(str[i]);
////		}
////		try {
////			Map<String,Object> check = om.readValue(str[0],Map.class);
////			System.out.println(check.toString());
////		} catch (JsonProcessingException e) {
////			e.printStackTrace();
////		}
//
//		List<QuestionsBank> qbList1 = new ArrayList<QuestionsBank>();
////		for (int i = 0; i < qbList.size(); i++) {
////			qbList1.add(qbs.InsertQuestion(qbList.get(i)));
////		}
//		//Log4j
//		LogThis.LogIt("info","Multiple Question added");
//		return qbList1;
//	}

	//change endpoint from /submitQuiz to /forward
	@RequestMapping(value = "/forward", method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody()
	public Result calculatePoints (@RequestBody List<Question> qList) {
		QuestionsBank qb = null;
		UserQuizScore uqs = new UserQuizScore();
		Result result = new Result();
		String userEmail = null;
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
			quizId = qb.getQuiz().getQuizId();

			if(qList.get(i).getSelectedAnswer().equalsIgnoreCase(qb.getCorrectAnswer())){
				totalPoints += qb.getQuestionValue();
				System.out.println(qList.get(i).getQuestionValue());
				correctAnswers++;
			}
		}

		uqs.setSubmitDate(date);
		uqs.setUserEmail(userEmail);
		uqs.setQuizId(quizId);
		uqs.setUserScore(totalPoints);

		uqss.InsertUserQuizScore(uqs);

		result.setTotalQuestions(totalQuestions);
		result.setCorrectAnswers(correctAnswers);
		result.setTotalPoints(totalPoints);

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
			Set<OptionsBank> options = obs.getOption(qbList.get(i).getQuestionId());
			q.setOptions(options);
//			    q.setOption1(qbList.get(i).getOption1());
//			    q.setOption2(qbList.get(i).getOption2());
//			    q.setOption3(qbList.get(i).getOption3());
//			    q.setOption4(qbList.get(i).getOption4());
//			    q.setOption5(qbList.get(i).getOption5());
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
