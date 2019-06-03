package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Database {

	private static List<Evaluation> productsGrades;

	private static List<User> users;

	private static List<Product> products;

	private static List<EvaluationGroup> evalGroups;
	
	private static List<ProductCategory> categories;
	
	

	public Database() {
		super();
		Database.categories.add(new ProductCategory("DD Cream")); //0
		Database.categories.add(new ProductCategory("CC Cream")); //1
		Database.categories.add(new ProductCategory("Powder Sunscreen")); //2
		Database.categories.add(new ProductCategory("BB Cream")); //3
		Database.categories.add(new ProductCategory("Foundation+SPF")); //4
		Database.categories.add(new ProductCategory("Oil Free Matte SPF")); //5
		
		Database.users.add(new User(1,"João", "RS", Arrays.asList(Database.categories.get(3), Database.categories.get(1), Database.categories.get(0))));
		Database.users.add(new User(2,"Ana", "SP", Arrays.asList(Database.categories.get(4), Database.categories.get(0), Database.categories.get(1))));
		Database.users.add(new User(3,"Manoela", "RS", Arrays.asList(Database.categories.get(3), Database.categories.get(5))));
		Database.users.add(new User(4,"Joana", "CE", Arrays.asList(Database.categories.get(3), Database.categories.get(1), Database.categories.get(4), Database.categories.get(2))));
		Database.users.add(new User(5,"Miguel", "RS", Arrays.asList(Database.categories.get(4), Database.categories.get(0), Database.categories.get(5))));
		Database.users.add(new User(6,"Beatriz", "CE", Arrays.asList(Database.categories.get(1), Database.categories.get(5), Database.categories.get(2))));
		Database.users.add(new User(7,"Suzana", "RS", Arrays.asList(Database.categories.get(2), Database.categories.get(0), Database.categories.get(1))));
		Database.users.add(new User(8,"Natasha", "CE", Arrays.asList(Database.categories.get(0), Database.categories.get(1), Database.categories.get(3))));
		Database.users.add(new User(9,"Pedro", "SP", Arrays.asList(Database.categories.get(2), Database.categories.get(4))));
		Database.users.add(new User(10,"Carla", "SP", Arrays.asList(Database.categories.get(1), Database.categories.get(0), Database.categories.get(5))));
		
		Database.evalGroups.add(new EvaluationGroup("SPF A", Arrays.asList(Database.users.get(0), Database.users.get(1), Database.users.get(2), Database.users.get(3), Database.users.get(4), Database.users.get(5), Database.users.get(6))));
		Database.evalGroups.add(new EvaluationGroup("SPF B", Arrays.asList(Database.users.get(0), Database.users.get(1), Database.users.get(2), Database.users.get(3), Database.users.get(4), Database.users.get(5), Database.users.get(6))));
		Database.evalGroups.add(new EvaluationGroup("SPF C", Arrays.asList(Database.users.get(3), Database.users.get(4), Database.users.get(5), Database.users.get(6), Database.users.get(7), Database.users.get(8), Database.users.get(9))));
	
		Database.products.add(new Product(1,"L'oreal DD Cream", Database.users.get(0), Database.categories.get(0), Database.evalGroups.get(2)));
		Database.products.add(new Product(2,"Avon CC Cream", Database.users.get(5), Database.categories.get(1), Database.evalGroups.get(1)));
		Database.products.add(new Product(3,"Revolution Powder Sunscreen", Database.users.get(6), Database.categories.get(2), Database.evalGroups.get(1)));
		Database.products.add(new Product(4,"Maybelline BB Cream", Database.users.get(7), Database.categories.get(3), Database.evalGroups.get(1)));
		Database.products.add(new Product(5,"Revlon Foundation+SPF20", Database.users.get(8), Database.categories.get(4), Database.evalGroups.get(1)));
		Database.products.add(new Product(6,"Nivea Matte Face SPF", Database.users.get(9), Database.categories.get(5), Database.evalGroups.get(1)));
		Database.products.add(new Product(7,"La Roche CC Cream", Database.users.get(5), Database.categories.get(1), Database.evalGroups.get(0)));
		Database.products.add(new Product(8,"Yves Rocher Powder+SPF15", Database.users.get(6), Database.categories.get(2), Database.evalGroups.get(0)));
		Database.products.add(new Product(9,"Nivea BB Cream", Database.users.get(7), Database.categories.get(3), Database.evalGroups.get(0)));
		Database.products.add(new Product(10,"Base O Boticário SPF20", Database.users.get(8), Database.categories.get(4), Database.evalGroups.get(0)));
		Database.products.add(new Product(11,"Natura SPF20 Rosto Matte", Database.users.get(9), Database.categories.get(5), Database.evalGroups.get(0)));
	
		Database.productsGrades.add(new Evaluation(2, Database.evalGroups.get(2), Database.products.get(0), Database.users.get(7)));
		Database.productsGrades.add(new Evaluation(Database.evalGroups.get(2), Database.products.get(0), Database.users.get(9)));
		Database.productsGrades.add(new Evaluation(2, Database.evalGroups.get(1), Database.products.get(1), Database.users.get(6)));
		Database.productsGrades.add(new Evaluation(3, Database.evalGroups.get(1), Database.products.get(1), Database.users.get(1)));
		Database.productsGrades.add(new Evaluation(-1, Database.evalGroups.get(1), Database.products.get(2), Database.users.get(3)));
		Database.productsGrades.add(new Evaluation(1, Database.evalGroups.get(1), Database.products.get(2), Database.users.get(5)));
		Database.productsGrades.add(new Evaluation(1, Database.evalGroups.get(1), Database.products.get(3), Database.users.get(0)));
		Database.productsGrades.add(new Evaluation(0, Database.evalGroups.get(1), Database.products.get(3), Database.users.get(2)));
		Database.productsGrades.add(new Evaluation(-3, Database.evalGroups.get(1), Database.products.get(4), Database.users.get(3)));
		Database.productsGrades.add(new Evaluation(-3, Database.evalGroups.get(1), Database.products.get(4), Database.users.get(4)));
		Database.productsGrades.add(new Evaluation(-1, Database.evalGroups.get(1), Database.products.get(5), Database.users.get(2)));
		Database.productsGrades.add(new Evaluation(0, Database.evalGroups.get(1), Database.products.get(5), Database.users.get(5)));
		
	}

	public static List<ProductCategory> getProductCatego() {
		return null;
	}

	public static List<User> getUsers() {
		return null;
	}

	public static Map<Product,List<String>> getProducts() {
		return null;
	}

	public static Map<Product,List<String>> getEvalGroups() {
		return null;
	}

	public static List<Product> getGroupProducts() {
		return null;
	}

	public static ProductCategory setProductGrades() {
		return null;
	}

	public static User getUser(String name) {
		return null;
	}

	public static EvaluationGroup getEvalGroup(String name) {
		return null;
	}

	public static Product getProduct(String name) {
		return null;
	}

}
