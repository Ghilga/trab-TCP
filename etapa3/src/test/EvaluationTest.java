package test;

import org.junit.*;

import domain.Database;
import domain.Evaluation;
import domain.EvaluationGroup;
import domain.Product;
import domain.User;

import static org.junit.Assert.*;

public class EvaluationTest {
	
	EvaluationGroup evalGroup;
	Product product;
	User reviewer;
	Evaluation eval;

	@Before
	public void setUp()
	{
		Database.initialize();
		evalGroup = Database.getEvalGroup(1);
		product = Database.getProduct(1);
		reviewer = Database.getUser(1);
		eval = new Evaluation(evalGroup, product, reviewer);
	}

	/*
	 * A avaliação está compĺeta quando score é
	 * diferente de zero?
	 */
	@Test
	public void testIsDoneTrue()
	{
		eval.setScore(3);
		assertTrue(eval.isDone());
	}
	
	@Test
	public void testIsDoneFalse()
	{
		assertFalse(eval.isDone());
		
	}
	
	@Test
	public void testSetScore()
	{
		int grade = 5;
		eval.setScore(grade);
		assertTrue(eval.getScore() == grade);
	}
}
