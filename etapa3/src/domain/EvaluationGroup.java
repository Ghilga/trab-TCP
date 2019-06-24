package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluationGroup {

	private String name;
	private Map<Product,List<Evaluation>> evaluations;
	private List<User> members;
	private List<Product> products;

	public EvaluationGroup(String name) {
		this.name = name;
		this.evaluations = new HashMap<>();
		this.products = null;
	}
	
	public EvaluationGroup(String name, List<User> members) {
		this.name = name;
		this.evaluations = new HashMap<>();
		this.members = members;
		this.products = null;
	}
	
	public void setProducts(List<Product> products){
		this.products = products;
	}
	
	public void setMembers(List<User> members) {
		this.members = members;
	}
	
	public List<User> getMembers() {
		return members;
	}
	
	public void addEvaluation(Product product, User reviewer) {
		Evaluation newEvaluation = new Evaluation(product.getGroup(), product, reviewer);
		if (evaluations.containsKey(product)){
			List<Evaluation> productEvals = new ArrayList<Evaluation>(evaluations.get(product));
			productEvals.add(newEvaluation);
			evaluations.replace(product, productEvals);
		}
		else {
			evaluations.put(product, Arrays.asList(newEvaluation));
		}
		product.addEvaluation(newEvaluation);
		reviewer.addEvaluation(newEvaluation);
	}

	public void allocate(int numEvaluators) {
		
		List<User> candidates;
		List<Product> productsToAllocate;
		
		for (int i = 0; i < numEvaluators; i++) {
			productsToAllocate = getOrderedProducts();
				while (!productsToAllocate.isEmpty()) {
					
					Product selectedProduct = productsToAllocate.get(0);
					candidates = getOrderedCandidateReviewers(selectedProduct);
					int j = 1;
					for (User c : candidates){
						if (j < numEvaluators)
							addEvaluation(selectedProduct, c);
						j++;
					}
					productsToAllocate.remove(selectedProduct);
				}
				
		}
		Database.saveEvalGroup(this);
	}

	public boolean evaluateDone() {
		return false;
	}
	
	public Map<Product, List<Evaluation>> getEvaluations() {
		return this.evaluations;
	}

	public List<Product> getAcceptableProducts() {
		List<Product> list = new ArrayList<Product>();
		for (Product p : evaluations.keySet()) {
			if (p.getScoreAvg() >= 0)
				list.add(p);
		}
		return list;
	}

	public List<Product> getNotAcceptableProducts() {
		List<Product> list = new ArrayList<Product>();
		for (Product p : evaluations.keySet()) {
			if (p.getScoreAvg() < 0)
				list.add(p);
		}
		return list;
	}

	public List<User> getOrderedCandidateReviewers(Product product) {
		List<User> orderedList = new ArrayList<User>();
		for (User member : members) {
			if(member.canEvaluate(product))
				orderedList.add(member);
		}
		return orderedList;
	}
	
	public List<Product> sortProductsById(List<Product> products){
		Comparator<Product> compareById = (Product p1, Product p2) -> p1.getId().compareTo( p2.getId() );
		products.sort(compareById);
		
		return products;
	}

	public List<Product> getOrderedProducts() {
		List<Product> orderedList = new ArrayList<>();
		if (products != null)
			for (Product product : products) {
				orderedList.add(product);
			}
		
		return sortProductsById(orderedList);
	}
	
	public String getName() {
		return name;
	}
	
	public User getUser(int index) {
		return members.get(index);
	}
	

	public boolean isAllocated() {
		if (evaluations.isEmpty())
            return false;
        else {
            for (Product product : products) {
                if (!evaluations.containsKey(product))
                    return false;
            }

            return true;
        }

	}

}