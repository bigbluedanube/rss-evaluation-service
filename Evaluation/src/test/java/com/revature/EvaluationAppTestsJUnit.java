package com.revature;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.revature.entity.OptionsBank;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.revature.controller.QuestionsBankController;
import com.revature.controller.QuizController;
import com.revature.controller.SubjectController;
import com.revature.entity.QuestionsBank;
import com.revature.entity.Quiz;
import com.revature.entity.Subject;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EvaluationAppTestsJUnit {
	
	@Autowired
	QuestionsBankController qbc;
	@Autowired
	QuizController qc;
	@Autowired
	SubjectController sc;

	private static OptionsBank ob1 = new OptionsBank();
	private static OptionsBank ob2 = new OptionsBank();
	private static OptionsBank ob3 = new OptionsBank();
	private static OptionsBank ob4 = new OptionsBank();
	private static OptionsBank ob5 = new OptionsBank();
	// Questions Bank Service JUnit Tests
	
//	@Test
//	public void insertQuestion() throws Exception{
//		QuestionsBank q = new QuestionsBank();
//		Set<OptionsBank> set = new HashSet<>();
//		long id = 1;
//		q.setQuizId(id);
//		q.setQuestion("What is Java?");
//		q.setCorrectAnswer("Object Oriented Programming Language");
////		q.setOption1("Object Oriented Programming Language");
////		q.setOption2("a kind of coffee");
////		q.setOption3("A name of a island");
////		q.setOption4(" An interpreted language");
////		q.setOption5("None of them");
//		q.setQuestionValue(5);
//		ob1.setOptionId(1000);
//		ob1.setOption("Object Oriented Programming Language");
//		ob1.setQuestion(q);
//		ob1.setQuestionId((long)1);
//		ob2.setOptionId(1001);
//		ob2.setOption("a kind of coffee");
//		ob2.setQuestion(q);
//		ob2.setQuestionId((long)1);
//		ob3.setOptionId(1002);
//		ob3.setOption("A name of a island");
//		ob3.setQuestion(q);
//		ob3.setQuestionId((long)1);
//		ob4.setOptionId(1003);
//		ob4.setOption("An interpreted language");
//		ob4.setQuestion(q);
//		ob4.setQuestionId((long)1);
//		ob5.setOptionId(1004);
//		ob5.setOption("None of them");
//		ob5.setQuestion(q);
//		ob5.setQuestionId((long)1);
//		set.add(ob1);
//		set.add(ob2);
//		set.add(ob3);
//		set.add(ob4);
//		set.add(ob5);
//		q.setOptions(set);
//		QuestionsBank result = qbc.insertQuestion(q);
//		int value = result.getQuestionValue();
//		assertEquals(5, value);
//	}
	
	// Quiz Service JUnit Tests
	
//	@Test
//	void insertQuiz() throws Exception{
//		Quiz q = new Quiz();
//		q.setQuizTopic("Eureka");
//		q.setCreatorEmail("vee@gmail.com");
//		q.setQuizDescription("This is a optional question.");
//		long id = 2;
//		q.setSubjectId(id);
//		Quiz result = qc.insertQuiz(q);
//		String topic = result.getQuizTopic();
//		assertEquals("Eureka", topic);
//	}
	
	@Test
	void findQuizById() throws Exception{
		Quiz q = new Quiz();
		long id = 1;
		q.setQuizId(id);
		assertThat(qc.findQuizById(q)).isNotNull();
	}
	
	// Subjects Service JUnit Tests
	
//	@Test
//	void insertSubject() throws Exception{
//		Subject s = new Subject();
//		s.setSubjectName("Hibernate");
//		String result = sc.insertSubject(s);
//		assertEquals("{'message':'Subject added successfully.'}", result);
//	}
	
	@Test
	void getAllSubjects() throws Exception{
		List<Subject> sublist;
		sublist = sc.getAllSubjects();
		assertTrue(sublist.size() != 0);
	}
	

}
