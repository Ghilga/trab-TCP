package domain;

import org.junit.*;
import static org.junit.Assert.*;

public class EvaluationTest {
	
	EvaluationGroup evalGroup;
	Product product;
	User reviewer;
	Evaluation eval;

	@Before
	public void setUp()
	{
		evalGroup = new EvaluationGroup();
		product = new Product();
		reviewer = new User();
		eval = new Evaluation(evalGroup, product, reviewer);
	}

	/*
	 * A avaliação está compĺeta quando score é
	 * diferente de zero?
	 */
	@Test
	public void testIsDone()
	{
		assertFalse(eval.isDone());
		
		eval.setScore(3);
		assertTrue(eval.isDone());
	}
	
	@Test
	public void testSetScore()
	{
		int grade = 5;
		eval.setScore(grade);
		assertTrue(eval.getScore() == grade);
	}
}
