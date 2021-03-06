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
	
	public User getRequester() {
		return requester;
	}
	
	public ProductCategory getProductCategory() {
		return category;
	}
	
	public void addEvaluation(Evaluation evaluation) {
		this.evaluations.put(evaluation.getReviewer(),evaluation);
		Database.saveProduct(this);
	}

	public void addScore(User user, int score) {
		evaluations.get(user).setScore(score);
		//define a nota no map evaluations e salva 
	}

	public Double getScoreAvg() {
		Double score = (double) 0;
		int counter = 0;
		for (Map.Entry<User, Evaluation> entry : evaluations.entrySet()) {
			score += entry.getValue().getScore();
			counter++;
		}
		score /= counter;
		return score;
	}
	
	public List<User> getEvaluators(){
		return new ArrayList<User>(evaluations.keySet());
	}

	public Integer getId() {
		return id;
	}
	
	public boolean hasEvaluators() {
		if(getEvaluators().isEmpty())
			return false;
		else
			return true;
	}
	
	public boolean isAcceptable() {
		return true;
	}

	public boolean evaluationDone(User evaluator) {
		if(evaluations.get(evaluator).isDone())
			return true;
		else
			return false;
	}
	
	@Override
	public String toString() {
		return "\nId: " + id + "\nNome: " + name + "\nSolicitante: " + requester + "\n";
	}

}
