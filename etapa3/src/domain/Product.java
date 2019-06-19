package domain;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
	
	public List<User> getEvaluators(){
		return new ArrayList<User>(evaluations.keySet());
	}

	public int getId() {
		return id;
	}
	
	public boolean isAcceptable() {
		return false;
	}

	public boolean evaluationDone() {
		return false;
	}

}
