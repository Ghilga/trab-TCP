package domain;

import java.util.Map;
import java.util.List;

public class EvaluationGroup {

	private String name;

	private Map<Product,List<Evaluation>> evalCommittee;

	private Evaluation evaluation;

	private Evaluation[] group;

	private User[] member;

	private Product[] products;

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
