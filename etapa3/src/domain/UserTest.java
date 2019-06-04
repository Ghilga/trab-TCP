package domain;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class UserTest {
	
	User testUser;
	
	@Before
	public void setUp() throws Exception {
		int id = 0;
		String name = null;
		String state = null;
		List<EvaluationGroup> groups = null;
		List<ProductCategory> categories = null;
		testUser = new User(id,name,state,categories,groups);
		
	}
	
	@Test
	public void testCanEvaluate(){
		assertTrue(testUser.canEvaluate());
	}
	
	@Test
	public void testAddEvaluation(){
		Evaluation evaluation = new Evaluation();
		testUser.addEvaluation(evaluation);
		assertTrue(testUser.hasEvaluation(evaluation));
	}
	
}
