package domain;

import java.util.Map;
import java.util.List;

public class EvaluationGroup {

	private String name;

	private Map<Product,List<Evaluation>> evalCommittee;


	private Evaluation evaluation;

	private List<Evaluation> group;

	private List<User> member;

	private List<Product> products;

	
	
	public EvaluationGroup(String name, List<User> member) {
		super();
		this.name = name;
		this.evalCommittee = null;
		this.evaluation = null;
		this.group = null;
		this.member = member;
		this.products = null;
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

	private List<User> getOrderedCandidateReviews() {
		return null;
	}

	private List<Product> getOrderedProducts() {
		return null;
	}

	public boolean isAllocated() {
		return false;
	}

}
