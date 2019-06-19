package domain;

import java.util.Map;

public class Product {

	private int id;
	private String name;
	private Map<User,Evaluation> evaluations;
	private ProductCategory category;
	private EvaluationGroup group;
	
	public Product(int id, String name, ProductCategory category, EvaluationGroup group) {
		super();
		this.id = id;
		this.name = name;
		this.evaluations = null;
		this.category = category;
		this.group = group;
	}

	public String getName() {
		return name;
	}
 

	public EvaluationGroup getGroup() {
		return group;
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
