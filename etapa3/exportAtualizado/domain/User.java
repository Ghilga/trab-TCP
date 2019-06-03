package domain;

import java.util.Map;

public class User {

	private int id;

	private String name;

	private String state;

	private Map<EvaluationGroup,List<Evaluation>> Evaluations;

	private Product[] assignedProducts;

	private EvaluationGroup[] groups;

	private Evaluation[] evaluation;

	private ProductCategory[] categories;

	public void addEvaluation(Evaluation evaluation) {

	}

	public boolean canEvaluate() {
		return false;
	}

}
