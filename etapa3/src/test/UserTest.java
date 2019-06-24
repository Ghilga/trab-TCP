package test;

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
	
	@Before
	public void setUp() throws Exception {
		Database.initialize();
		int id = 0;
		String name = null;
		String state = null;
		List<EvaluationGroup> groups = null;
		List<ProductCategory> categories = null;
		testUser = new User(id,name,state,categories,groups);

		
	}
		
	@Test
	public void testAddEvaluation(){
		EvaluationGroup evalGroup = Database.getEvalGroup(1);
		Product product = Database.getProduct(1);
		Evaluation eval = new Evaluation(evalGroup, product, testUser);
		testUser.addEvaluation(eval);
		assertTrue(testUser.hasEvaluation(eval));
	}
	
	@Test
	public void canEvaluate2() {
		Product product = Database.getProduct(2);
		User user = Database.getUser(1);
		assertTrue(user.canEvaluate(product));
	}
	
	@Test
	public void hasEvaluationTest() {
		Evaluation eval = Database.getEvaluation(2);
		User user = Database.getUser(5);
		user.addEvaluation(eval);
		assertTrue(user.hasEvaluation(eval));
	}
	
	@Test
	public void getOrderedReviewers() {
		EvaluationGroup evalGroup = Database.getEvalGroup(0);
		Product product = Database.getProduct(6);
		List<User> users = evalGroup.getOrderedCandidateReviewers(product);
		for (User u : users)
			System.out.println(u.getName());
	}
	
}
