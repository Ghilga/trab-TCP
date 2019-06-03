package domain;

import java.util.List;
import java.util.Map;

public class Product {

	private int id;

	private String name;

	private Map<User,Evaluation> evaluations;

	private User requestedBy;

	private List<Evaluation> evaluation;

	private ProductCategory category;

	private EvaluationGroup group;

	
	
	public Product(int id, String name, User requestedBy, ProductCategory category, EvaluationGroup group) {
		super();
		this.id = id;
		this.name = name;
		this.evaluations = null;
		this.requestedBy = requestedBy;
		this.evaluation = null;
		this.category = category;
		this.group = group;
	}

	public void addEvaluation(Evaluation evaluation) {

	}

	public void addScore(User user, int score) {

	}

	public double getScoreAvg() {
		return 0;
	}

	public boolean isAcceptable() {
		return false;
	}

	public boolean evaluationDone() {
		return false;
	}

}
