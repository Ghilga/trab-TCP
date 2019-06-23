package domain;

import java.util.ArrayList;
import java.util.Arrays;
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
	
	public boolean canEvaluate(Product product) {
		return true;
	}
	
	public void addEvaluation(Evaluation evaluation) {
		EvaluationGroup evalGroup = evaluation.getEvaluationGroup();
		
		if(evaluations.containsKey(evalGroup)){
			evaluations.get(evalGroup).add(evaluation);
		}
		else {
			ArrayList<Evaluation> list = new ArrayList<Evaluation>();
			list.add(evaluation);
			evaluations.put(evalGroup, list);
		}
		
		Database.saveEvaluation(evaluation);
	}
	
	public boolean hasEvaluation(Evaluation evaluation) {
		for (Map.Entry<EvaluationGroup, List<Evaluation>> entry : evaluations.entrySet()) {
		    for(Evaluation eval : entry.getValue())
		    	if (eval.equals(evaluation))
		    		return true;
		    	
		}
		return false;

	}

}
