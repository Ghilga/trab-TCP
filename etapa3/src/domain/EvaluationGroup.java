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
	
	public void setMembers(List<User> members) {
		this.members = members;
	}
	
	public List<User> getMembers() {
		return members;
	}
	
	private void addEvaluation(Product product, User reviwer) {

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

	public List<User> getOrderedCandidateReviewers() {
		return null;
	}

	public List<Product> getOrderedProducts() {
		return null;
	}
	
	public String getName() {
		return name;
	}

	public boolean isAllocated() {
		return false;
	}

}