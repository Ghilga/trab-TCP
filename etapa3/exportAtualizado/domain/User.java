package domain;

import java.util.List;
import java.util.Map;

public class User {

	private int id;

	private String name;

	private String state;

	private Map<EvaluationGroup,List<Evaluation>> evaluations;

	private List<Product> assignedProducts;

	private List<EvaluationGroup> groups;

	private List<ProductCategory> categories;
	

	//inicialização para testes
	public User(int id, String name, String state, List<ProductCategory> categoryList) {
		super();
		this.id = id;
		this.name = name;
		this.state = state;
		this.categories = categoryList;
		this.evaluations = null;
		this.groups = null;
		
	}

	


	public void addEvaluation(Evaluation evaluation) {

	}

	public boolean canEvaluate() {
		return false;
	}

}
