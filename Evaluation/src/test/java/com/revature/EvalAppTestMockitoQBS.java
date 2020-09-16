//package com.revature;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//
//import java.util.HashSet;
//import java.util.Set;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//import com.revature.entity.OptionsBank;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.testng.annotations.BeforeClass;
//
//import com.revature.entity.QuestionsBank;
//import com.revature.entity.Quiz;
//import com.revature.entity.Subject;
//import com.revature.service.QuestionsBankService;
//
//@SpringBootTest
//public class EvalAppTestMockitoQBS {
//
//	private static Quiz quiz;
//	private static Subject subject;
//	private static QuestionsBank qb;
//	private static OptionsBank ob1 = new OptionsBank();
//	private static OptionsBank ob2 = new OptionsBank();
//
//
//	QuestionsBankService qbsService = Mockito.mock(QuestionsBankService.class);
//
//	@BeforeClass
//	public void initialize() throws Exception {
//		Set<OptionsBank> set = new HashSet<>();
//		subject = new Subject((long)2,"Test");
//		quiz = new Quiz((long)1, "Java Bean", "description", "test@rev.com", (long)2, subject);
//
//		qb = new QuestionsBank();
//		qb.setQuestionId((long)1);
//		qb.setQuestionValue(5);
//		qb.setQuestion("Test");
//		ob1.setOptionId(1000);
//		ob1.setOption("option1");
//		ob1.setQuestion(qb);
//		ob1.setQuestionId((long)1);
//		ob2.setOptionId(1001);
//		ob2.setOption("option2");
//		ob2.setQuestion(qb);
//		ob2.setQuestionId((long)1);
//		set.add(ob1);
//		set.add(ob2);
////		qb.setOptions(set);
////		qb.setOption1("option1");
////		qb.setOption2("option2");
//		qb.setCorrectAnswer("option1");
//		qb.setQuiz(quiz);
//	}
//
//
//	/** Test Methods in QuestionsBankService **/
//
//	@Test
//	public void findAllQuestionsTest() {
//
//		when(qbsService.findAllQuestions()).thenReturn(Stream
//				.of(new QuestionsBank()).collect(Collectors.toList()));
//
//		assertEquals(1, qbsService.findAllQuestions().size());
//
//	}
//
//	@Test
//	public void findQuestionsByQuizTest() {
//
//		when(qbsService.findQuestionsByQuiz(qb)).thenReturn(Stream
//				.of(new QuestionsBank()).collect(Collectors.toList()));
//
//		assertEquals(1, qbsService.findQuestionsByQuiz(qb).size());
//	}
//
//	@Test
//	public void getQuestionTest(){
//		QuestionsBank qb1 = qbsService.getQuestion((long)1);
//
//		assertEquals(qb, qb1);
//	}
//
//	@Test
//	public void insertQuestionTest() {
//
//		when(qbsService.InsertQuestion(qb)).thenReturn(qb);
//		assertEquals(qb, qbsService.InsertQuestion(qb));
//	}
//
//}
