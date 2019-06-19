package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Database {

	private static List<Evaluation> productsGrades;
	private static List<User> users;
	private static List<Product> products;
	private static List<EvaluationGroup> evalGroups;
	private static List<ProductCategory> categories;	

	public Database() {
		
		initialize();
	}
	
	public void initialize() {
		Database.categories = new ArrayList<ProductCategory>();
		Database.evalGroups = new ArrayList<EvaluationGroup>();
		Database.users = new ArrayList<User>();
		Database.products = new ArrayList<Product>();
		Database.productsGrades = new ArrayList<Evaluation>();
		
		Database.categories.add(new ProductCategory("DD Cream")); 			//0
		Database.categories.add(new ProductCategory("CC Cream")); 			//1
		Database.categories.add(new ProductCategory("Powder Sunscreen")); 	//2
		Database.categories.add(new ProductCategory("BB Cream")); 			//3
		Database.categories.add(new ProductCategory("Foundation+SPF")); 	//4
		Database.categories.add(new ProductCategory("Oil Free Matte SPF")); //5
		
		Database.evalGroups.add(new EvaluationGroup("SPF A"));
		Database.evalGroups.add(new EvaluationGroup("SPF B"));
		Database.evalGroups.add(new EvaluationGroup("SPF C"));
	
		Database.users.add(new User(1,"João", "RS", Arrays.asList(Database.categories.get(3), Database.categories.get(1), Database.categories.get(0)), Arrays.asList(Database.evalGroups.get(0),Database.evalGroups.get(1))));
		Database.users.add(new User(2,"Ana", "SP", Arrays.asList(Database.categories.get(4), Database.categories.get(0), Database.categories.get(1)), Arrays.asList(Database.evalGroups.get(0),Database.evalGroups.get(1))));
		Database.users.add(new User(3,"Manoela", "RS", Arrays.asList(Database.categories.get(3), Database.categories.get(5)), Arrays.asList(Database.evalGroups.get(0),Database.evalGroups.get(1))));
		Database.users.add(new User(4,"Joana", "CE", Arrays.asList(Database.categories.get(3), Database.categories.get(1), Database.categories.get(4), Database.categories.get(2)), Arrays.asList(Database.evalGroups.get(0),Database.evalGroups.get(1),Database.evalGroups.get(2))));
		Database.users.add(new User(5,"Miguel", "RS", Arrays.asList(Database.categories.get(4), Database.categories.get(0), Database.categories.get(5)), Arrays.asList(Database.evalGroups.get(0),Database.evalGroups.get(1),Database.evalGroups.get(2))));
		Database.users.add(new User(6,"Beatriz", "CE", Arrays.asList(Database.categories.get(1), Database.categories.get(5), Database.categories.get(2)), Arrays.asList(Database.evalGroups.get(0),Database.evalGroups.get(1),Database.evalGroups.get(2))));
		Database.users.add(new User(7,"Suzana", "RS", Arrays.asList(Database.categories.get(2), Database.categories.get(0), Database.categories.get(1)), Arrays.asList(Database.evalGroups.get(0),Database.evalGroups.get(1),Database.evalGroups.get(2))));
		Database.users.add(new User(8,"Natasha", "CE", Arrays.asList(Database.categories.get(0), Database.categories.get(1), Database.categories.get(3)), Arrays.asList(Database.evalGroups.get(2))));
		Database.users.add(new User(9,"Pedro", "SP", Arrays.asList(Database.categories.get(2), Database.categories.get(4)), Arrays.asList(Database.evalGroups.get(2))));
		Database.users.add(new User(10,"Carla", "SP", Arrays.asList(Database.categories.get(1), Database.categories.get(0), Database.categories.get(5)), Arrays.asList(Database.evalGroups.get(2))));
		
		Database.evalGroups.get(0).setMembers(Arrays.asList(Database.users.get(0), Database.users.get(1), Database.users.get(2), Database.users.get(3), Database.users.get(4), Database.users.get(5), Database.users.get(6)));
		Database.evalGroups.get(1).setMembers(Arrays.asList(Database.users.get(0), Database.users.get(1), Database.users.get(2), Database.users.get(3), Database.users.get(4), Database.users.get(5), Database.users.get(6)));
		Database.evalGroups.get(2).setMembers(Arrays.asList(Database.users.get(3), Database.users.get(4), Database.users.get(5), Database.users.get(6), Database.users.get(7), Database.users.get(8), Database.users.get(9)));
		
		Database.products.add(new Product(1,"L'oreal DD Cream", Database.categories.get(0), Database.evalGroups.get(2)));
		Database.products.add(new Product(2,"Avon CC Cream", Database.categories.get(1), Database.evalGroups.get(1)));
		Database.products.add(new Product(3,"Revolution Powder Sunscreen", Database.categories.get(2), Database.evalGroups.get(1)));
		Database.products.add(new Product(4,"Maybelline BB Cream", Database.categories.get(3), Database.evalGroups.get(1)));
		Database.products.add(new Product(5,"Revlon Foundation+SPF20", Database.categories.get(4), Database.evalGroups.get(1)));
		Database.products.add(new Product(6,"Nivea Matte Face SPF", Database.categories.get(5), Database.evalGroups.get(1)));
		Database.products.add(new Product(7,"La Roche CC Cream", Database.categories.get(1), Database.evalGroups.get(0)));
		Database.products.add(new Product(8,"Yves Rocher Powder+SPF15", Database.categories.get(2), Database.evalGroups.get(0)));
		Database.products.add(new Product(9,"Nivea BB Cream", Database.categories.get(3), Database.evalGroups.get(0)));
		Database.products.add(new Product(10,"Base O Boticário SPF20", Database.categories.get(4), Database.evalGroups.get(0)));
		Database.products.add(new Product(11,"Natura SPF20 Rosto Matte", Database.categories.get(5), Database.evalGroups.get(0)));
	
		
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
	
	public Evaluation getProductsGrade(int id) {
		if (id >= productsGrades.size() || id < 0)
			return null;
		else
			return productsGrades.get(id);
	}

	public ProductCategory getCategorie(int id) {
		if (id >= categories.size() || id < 0)
			return null;
		else
			return categories.get(id);
	}

	public User getUser(int id) {
		if (id >= users.size() || id < 0)
			return null;
		else
			return users.get(id);
	}

	public Product getProduct(int id) {
		if (id >= products.size() || id < 0)
			return null;
		else
			return products.get(id);
	}

	public EvaluationGroup getEvalGroup(int id) {
		if (id >= evalGroups.size() || id < 0)
			return null;
		else
			return evalGroups.get(id);
	}


	public static List<User> getUsers() {
		return users;
	}

	public static List<Product> getProducts() {
		return products;
	}

	public static List<EvaluationGroup> getEvalGroups() {
		return evalGroups;
	}
	
	public static List<Evaluation> getProductsGrades(){
		return productsGrades;
	}

	public User findUser(String name) {
		return null;
	}

	public Product findProduct(String name) {
		return null;
	}

	public EvaluationGroup findEvalGroup(String name) {
		return null;
	}
	
	public static void saveEvalGroup(EvaluationGroup evalGroup) {
		
	}

}