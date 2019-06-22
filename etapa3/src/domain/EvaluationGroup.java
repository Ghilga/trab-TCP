package domain;

import java.util.Map;
import java.util.List;

public class EvaluationGroup {

	private String name;
	private Map<Product,List<Evaluation>> evaluations;
	private List<User> members;
	private List<Product> products;

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
	
	public User findUser(String name) {
		User u = null;
		for (User user : this.members) {
			if (user.getName().contentEquals(name))
				u = user;
		}
		return u;
	}
	
	public void setMembers(List<User> members) {
		this.members = members;
	}
	
	public List<User> getMembers() {
		return members;
	}
	
	public void addEvaluation(Product product, User reviewer) {

	}

	public void allocate(int numMembers) {

	}

	public boolean evaluateDone() {
		return false;
	}

	public List<Product> getAcceptableProducts() {
		return null;
	}

	public List<Product> getNotAcceptableProducts() {
		return null;
	}

	public List<User> getOrderedCandidateReviewers(Product product) {
		return null;
	}

	public List<Product> getOrderedProducts() {
		return null;
	}
	
	public String getName() {
		return name;
	}
	
	public User getUser(String name) {
		return members.
	}

	public boolean isAllocated() {
		return false;
	}

}