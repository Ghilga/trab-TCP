package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Database {

	private static List<Evaluation> evaluations;
	private static List<User> users;
	private static List<Product> products;
	private static List<EvaluationGroup> evalGroups;
	private static List<ProductCategory> categories;	

	public Database() {
		
		initialize();
	}
	
	public static void initialize() {
		Database.categories = new ArrayList<ProductCategory>();
		Database.evalGroups = new ArrayList<EvaluationGroup>();
		Database.users = new ArrayList<User>();
		Database.products = new ArrayList<Product>();
		Database.evaluations = new ArrayList<Evaluation>();
		
		Database.categories.add(new ProductCategory("DD Cream")); 			//0
		Database.categories.add(new ProductCategory("CC Cream")); 			//1
		Database.categories.add(new ProductCategory("Powder Sunscreen")); 	//2
		Database.categories.add(new ProductCategory("BB Cream")); 			//3
		Database.categories.add(new ProductCategory("Foundation+SPF")); 	//4
		Database.categories.add(new ProductCategory("Oil Free Matte SPF")); //5
		
		Database.evalGroups.add(new EvaluationGroup("SPF A"));
		Database.evalGroups.add(new EvaluationGroup("SPF B"));
		Database.evalGroups.add(new EvaluationGroup("SPF C"));
	
		Database.users.add(new User(1,"Jo�o", "RS", Arrays.asList(Database.categories.get(3), Database.categories.get(1), Database.categories.get(0)), Arrays.asList(Database.evalGroups.get(0),Database.evalGroups.get(1))));
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
		
		Database.products.add(new Product(1,"L'oreal DD Cream", Database.users.get(0), Database.categories.get(0), Database.evalGroups.get(2)));
		Database.products.add(new Product(2,"Avon CC Cream", Database.users.get(5), Database.categories.get(1), Database.evalGroups.get(1)));
		Database.products.add(new Product(3,"Revolution Powder Sunscreen", Database.users.get(6), Database.categories.get(2), Database.evalGroups.get(1)));
		Database.products.add(new Product(4,"Maybelline BB Cream", Database.users.get(7), Database.categories.get(3), Database.evalGroups.get(1)));
		Database.products.add(new Product(5,"Revlon Foundation+SPF20", Database.users.get(8), Database.categories.get(4), Database.evalGroups.get(1)));
		Database.products.add(new Product(6,"Nivea Matte Face SPF", Database.users.get(9), Database.categories.get(5), Database.evalGroups.get(1)));
		Database.products.add(new Product(7,"La Roche CC Cream", Database.users.get(5), Database.categories.get(1), Database.evalGroups.get(0)));
		Database.products.add(new Product(8,"Yves Rocher Powder+SPF15", Database.users.get(6), Database.categories.get(2), Database.evalGroups.get(0)));
		Database.products.add(new Product(9,"Nivea BB Cream", Database.users.get(7), Database.categories.get(3), Database.evalGroups.get(0)));
		Database.products.add(new Product(10,"Base O Botic�rio SPF20", Database.users.get(8), Database.categories.get(4), Database.evalGroups.get(0)));
		Database.products.add(new Product(11,"Natura SPF20 Rosto Matte", Database.users.get(9), Database.categories.get(5), Database.evalGroups.get(0)));
		
		Database.evaluations.add(new Evaluation(2, Database.evalGroups.get(2), Database.products.get(0), Database.users.get(7)));
		Database.evaluations.add(new Evaluation(null, Database.evalGroups.get(2), Database.products.get(0), Database.users.get(9)));
		Database.evaluations.add(new Evaluation(2, Database.evalGroups.get(1), Database.products.get(1), Database.users.get(6)));
		Database.evaluations.add(new Evaluation(3, Database.evalGroups.get(1), Database.products.get(1), Database.users.get(1)));
		Database.evaluations.add(new Evaluation(-1, Database.evalGroups.get(1), Database.products.get(2), Database.users.get(3)));
		Database.evaluations.add(new Evaluation(1, Database.evalGroups.get(1), Database.products.get(2), Database.users.get(5)));
		Database.evaluations.add(new Evaluation(1, Database.evalGroups.get(1), Database.products.get(3), Database.users.get(0)));
		Database.evaluations.add(new Evaluation(0, Database.evalGroups.get(1), Database.products.get(3), Database.users.get(2)));
		Database.evaluations.add(new Evaluation(-3, Database.evalGroups.get(1), Database.products.get(4), Database.users.get(3)));
		Database.evaluations.add(new Evaluation(-3, Database.evalGroups.get(1), Database.products.get(4), Database.users.get(4)));
		Database.evaluations.add(new Evaluation(-1, Database.evalGroups.get(1), Database.products.get(5), Database.users.get(2)));
		Database.evaluations.add(new Evaluation(0, Database.evalGroups.get(1), Database.products.get(5), Database.users.get(5)));
		
		Database.products.get(0).addEvaluation(evaluations.get(0));
		Database.products.get(0).addEvaluation(evaluations.get(1));
		Database.products.get(1).addEvaluation(evaluations.get(2));
		Database.products.get(1).addEvaluation(evaluations.get(3));
		Database.products.get(2).addEvaluation(evaluations.get(4));
		Database.products.get(2).addEvaluation(evaluations.get(5));
		Database.products.get(3).addEvaluation(evaluations.get(6));
		Database.products.get(3).addEvaluation(evaluations.get(7));
		Database.products.get(4).addEvaluation(evaluations.get(8));
		Database.products.get(4).addEvaluation(evaluations.get(9));
		Database.products.get(5).addEvaluation(evaluations.get(10));
		Database.products.get(5).addEvaluation(evaluations.get(11));
		
		Database.evalGroups.get(0).setProducts(Arrays.asList(products.get(6), products.get(7), products.get(8), products.get(9), products.get(10)));
		Database.evalGroups.get(1).setProducts(Arrays.asList(products.get(1), products.get(2), products.get(3), products.get(4), products.get(5)));
		Database.evalGroups.get(2).setProducts(Arrays.asList(products.get(0)));

	}
	
	public static Evaluation getProductsGrade(int id) {
		if (id >= evaluations.size() || id < 0)
			return null;
		else
			return evaluations.get(id);
	}

	public static ProductCategory getCategorie(int id) {
		if (id >= categories.size() || id < 0)
			return null;
		else
			return categories.get(id);
	}

	public static User getUser(int id) {
		User user = null;
		for (User u : users)
			if (id == u.getId())
				user = u;
		return user;	
	}

	public static Product getProduct(int id) {
		if (id >= products.size() || id < 0)
			return null;
		else
			return products.get(id);
	}

	public static EvaluationGroup getEvalGroup(int id) {
		if (id >= evalGroups.size() || id < 0)
			return null;
		else
			return evalGroups.get(id);
	}
	
	public static Evaluation getEvaluation(int id){
		if (id >= evaluations.size() || id < 0)
			return null;
		else
			return evaluations.get(id);
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
	
	public static List<Evaluation> getEvaluations(){
		return evaluations;
	}

	public static User findUser(String name) {
		User u = null;
		for (User user : users) {
			if (user.getName().contentEquals(name))
				u = user;
		}
		return u;
	}

	public static Product findProduct(String name) {
		Product p = null;
		for (Product product : products) {
			if (product.getName().contentEquals(name))
				p = product;
		}
		return p;
	}
	
	public static Evaluation findEvaluation(int productId, int userId) {
		Evaluation e = null;
		for (Evaluation eval : evaluations) {
			if (eval.getProduct().getId() == productId && eval.getReviewer().getId() == userId)
				e = eval;
		}
		return e;
	}


	public static EvaluationGroup findEvalGroup(String name) {
		return null;
	}
	
	public static void saveEvalGroup(EvaluationGroup evalGroup) {
		
	}
	
	public static void saveUser(User user) {
		int index = users.indexOf(user);
		users.set(index, user);
	
	}
	
	public static void saveProduct(Product product) {
		int index = products.indexOf(product);
		products.set(index, product);
	}
	
	public static void saveEvaluation(Evaluation evaluation) {
		if(evaluations.contains(evaluation)) {
			int index = evaluations.indexOf(evaluation);
			evaluations.set(index, evaluation);
		}
		else
			evaluations.add(evaluation);
	}
	

}