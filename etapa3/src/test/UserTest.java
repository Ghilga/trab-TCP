package test;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

import domain.Database;
import domain.Evaluation;
import domain.EvaluationGroup;
import domain.Product;
import domain.ProductCategory;
import domain.User;

public class UserTest {
	
	User testUser;
	EvaluationGroup evalGroup;
	Product product;
	User reviewer;
	Evaluation eval;
	
	@Before
	public void setUp() throws Exception {
		int id = 0;
		String name = null;
		String state = null;
		List<EvaluationGroup> groups = null;
		List<ProductCategory> categories = null;
		testUser = new User(id,name,state,categories,groups);

		evalGroup = Database.getEvalGroup(1);
		product = Database.getProduct(1);
		reviewer = Database.getUser(1);
		eval = new Evaluation(evalGroup, product, reviewer);
		

		
	}
	
	@Test
	public void testCanEvaluate(){
		assertTrue(testUser.canEvaluate());
	}
	
	@Test
	public void testAddEvaluation(){
		Evaluation evaluation = eval;
		testUser.addEvaluation(evaluation);
		assertTrue(testUser.hasEvaluation(evaluation));
	}
	
}
