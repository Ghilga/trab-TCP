package domain;

import org.junit.*;
import static org.junit.Assert.*;

public class ProductCategoryTest {
	
	ProductCategory cat;
	String testName = "Shampoo";
	
	@Before
	public void setUp()
	{
		cat = new ProductCategory(testName);
	}
	
	@Test
	public void testSetName()
	{
		String newName = "Cream";
		cat.setName(newName);
		
		assertTrue(cat.getName() == newName);
	}
	
	@Test
	public void testGetName()
	{
		assertTrue(cat.getName() == testName);
	}
	

}
