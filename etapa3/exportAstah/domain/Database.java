package domain;

import java.util.List;
import java.util.Map;

public class Database {

	private static List<ProductCategory> productsGrades;

	private static List<User> users;

	private static List<Product> products;

	private static List<EvaluationGroup> evalGroups;
	
	private static List<ProductCategory> categories;
	
	

	public Database() {
		super();
		this.categories.add(new ProductCategory("bolo"));
		this.users.add(new User(1,"Ad�o", "Paraiso", Database.categories.get(0)));
	}

	public static List<ProductCategory> getGrades() {
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
