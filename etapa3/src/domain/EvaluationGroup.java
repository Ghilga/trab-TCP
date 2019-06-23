package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EvaluationGroup {

	private String name;
	private Map<Product,List<Evaluation>> evaluations;
	private List<User> members;
	public List<Product> products;

	public EvaluationGroup(String name) {
		this.name = name;
		this.evaluations = null;
		this.products = null;
	}
	
	public EvaluationGroup(String name, List<User> members) {
		this.name = name;
		this.evaluations = null;
		this.members = members;
		this.products = null;
	}
	
	public void setProducts(List<Product> products){
		this.products = products;
	}
	
	public void setMembers(List<User> members) {
		this.members = members;
	}
	
	public List<User> getMembers() {
		return members;
	}
	
	public void addEvaluation(Product product, User reviewer) {
		List<Evaluation> evaluationList = evaluations.get(product);
		Evaluation newEvaluation = new Evaluation(null, product.getGroup(), product, reviewer);
		if (evaluationList  == null)
			evaluations.put(product, evaluationList);
		
		evaluationList.add(newEvaluation);
	}

	public void allocate(int numMembers) {

	}

	public boolean evaluateDone() {
		return false;
	}
	
	public Map<Product, List<Evaluation>> getEvaluations() {
		return this.evaluations;
	}

	public List<Product> getAcceptableProducts() {
		return null;
	}

	public List<Product> getNotAcceptableProducts() {
		return null;
	}

	public List<User> getOrderedCandidateReviewers(Product product) {
		List<User> orderedList = new ArrayList<User>();
		for (User member : members) {
			if(member.canEvaluate(product))
				orderedList.add(member);
		}
		
		return orderedList;
	}

	public List<Product> getOrderedProducts() {
		List<Product> orderedList = new ArrayList<>();
		if (products != null)
			for (Product product : products) {
				orderedList.add(product);
			}
		
		return orderedList;
	}
	
	public String getName() {
		return name;
	}
	
	public User getUser(int index) {
		return members.get(index);
	}
	
	public User findUser(String name) {
		User u = null;
		for (User user : this.members) {
			if (user.getName().contentEquals(name))
				u = user;
		}
		return u;
	}

	public boolean isAllocated() {
		return false;
	}

}