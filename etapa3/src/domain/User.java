package domain;

import java.util.List;
import java.util.Map;

public class User {

	private int id;
	private String name;
	private String state;
	private Map<EvaluationGroup,List<Evaluation>> evaluations;
	private List<EvaluationGroup> evalGroups;
	private List<ProductCategory> categories;
	
	public User(int id, String name, String state, List<ProductCategory> categoryList, List<EvaluationGroup> groups) {
		this.id = id;
		this.name = name;
		this.state = state;
		this.categories = categoryList;
		this.evaluations = null;
		this.evalGroups = groups;
		
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean canEvaluate() {
		return true;
	}
	
	public void addEvaluation(Evaluation evaluation) {

	}
	
	public boolean hasEvaluation(Evaluation evaluation) {
		return false;
	}

}
