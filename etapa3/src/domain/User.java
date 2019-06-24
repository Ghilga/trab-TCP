package domain;

import java.util.ArrayList;
import java.util.HashMap;
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
		this.evaluations = new HashMap<EvaluationGroup,List<Evaluation>>();
		this.evalGroups = groups;
		
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getState() {
		return state;
	}
	
	public boolean canEvaluate(Product product) {
		User requester = product.getRequester();
		String requesterState = requester.getState();
		ProductCategory productCategory = product.getProductCategory();
		
		boolean isInvalidEvaluator = requester.equals(this) || requesterState.equals(state) 
				|| !categories.contains(productCategory) || product.getEvaluators().contains(this);
		if(isInvalidEvaluator)
			return false;
		else
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
