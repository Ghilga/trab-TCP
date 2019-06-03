package domain;

import java.util.Map;

public class Product {

	private int id;

	private String name;

	private Map<User,Evaluation> evaluations;

	private User requestedBy;

	private Evaluation[] evaluation;

	private ProductCategory category;

	private EvaluationGroup group;

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
