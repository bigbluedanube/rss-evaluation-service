package com.revature;

import static org.junit.jupiter.api.Assertions.*;

import com.revature.entity.OptionsBank;
import com.revature.service.QuestionsBankService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.revature.controller.QuestionsBankController;
import com.revature.entity.QuestionsBank;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
class EvaluationQuestionsBankTests {
	
	@Autowired
	QuestionsBankController qbc;

	private static OptionsBank ob1 = new OptionsBank();
	private static OptionsBank ob2 = new OptionsBank();
	private static OptionsBank ob3 = new OptionsBank();
	private static OptionsBank ob4 = new OptionsBank();
	private static OptionsBank ob5 = new OptionsBank();

	
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
//		q.setQuestionValue(5);
//		QuestionsBank result = qbc.insertQuestion(q);
//		int value = result.getQuestionValue();
//		assertEquals(5, value);
//	}

}
