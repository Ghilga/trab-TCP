package test;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import domain.Database;
import domain.Evaluation;
import domain.Product;
import domain.User;

public class ProductTest {

	private Product productTest;
	@Before
	public void setUp() throws Exception {
		Database.initialize();
		productTest = Database.getProduct(3);
	}
	
	@Test
	public void addEvalTest() {
		Evaluation expected = Database.getEvaluation(4);
		this.productTest.addEvaluation(expected);
		
	}
	
}
