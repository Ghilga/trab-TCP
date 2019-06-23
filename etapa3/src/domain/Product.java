package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Product {

	private int id;
	private String name;
	private Map<User,Evaluation> evaluations;
	private ProductCategory category;
	private EvaluationGroup group;
	private User requester;
	
	public Product(int id, String name, User requester, ProductCategory category, EvaluationGroup group) {
		super();
		this.id = id;
		this.name = name;
		this.evaluations = new HashMap<User, Evaluation>();
		this.requester = requester;
		this.category = category;
		this.group = group;
		
	}

	public String getName() {
		return name;
	}
	
 

	public EvaluationGroup getGroup() {
		return group;
	}
	
	public void addEvaluation(User reviewer, Evaluation evaluation) {
		this.evaluations.put(reviewer,evaluation);
	}

	public void addScore(User user, int score) {

	}

	public Double getScoreAvg() {
		Double score = (double) 0;
		return score;
	}
	
	public List<User> getEvaluators(){
		return new ArrayList<User>(evaluations.keySet());
	}

	public int getId() {
		return id;
	}
	
	public boolean isAcceptable() {
		return true;
	}

	public boolean evaluationDone() {
		return false;
	}


}
