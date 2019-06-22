package UI;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.Database;
import domain.Evaluation;
import domain.EvaluationGroup;
import domain.Product;
import domain.User;

public class EvaluationCommand extends UICommand{
	
	private Map<Integer,Product> productsMap;
	private Map<Integer,User> reviewersMap;
	
	public EvaluationCommand() {
		initializeProductsMap();
	}
	
	public void execute() {
		Product productInEvaluation;
		displayProducts(Database.getProducts());
		System.out.println("Escolha um produto da lista acima: ");
		do {
			
			int selectedIndex = ApplicationIO.readInteger();
			productInEvaluation = productsMap.get(selectedIndex);
			if (productInEvaluation == null)
				System.out.println("Produto invalido, digite o indice de um produto da lista.");
		}while (productInEvaluation == null);
		
		User reviewer = askEvaluator(productInEvaluation);
		int evaluationScore = askEvaluationScore();
		Evaluation evaluation = createEvaluation(reviewer,evaluationScore);
	
	}
	
	private void initializeProductsMap() {
		productsMap = new HashMap<>();
		List<Product> products = Database.getProducts();
		
		for (int i = 0; i < products.size(); i++) {
			productsMap.put(i+1, products.get(i));
		}
		
	}
	
	private void initializeReviewersMap(List<User> reviewers) {
		reviewersMap = new HashMap<>();
		
		for (int i = 0; i < reviewers.size(); i++) {
			reviewersMap.put(i+1, reviewers.get(i));
		}
		
	}
	
	private User askEvaluator(Product product) {
		
		EvaluationGroup group = product.getGroup();
		initializeReviewersMap(group.getMembers());
		displayUsers(group.getMembers());
		
		User evaluator;
		
		do {
			
			int evaluatorIndex = ApplicationIO.readInteger();
			evaluator = reviewersMap.get(evaluatorIndex);
			if (evaluator == null)
				System.out.println("Avaliador invalido, digite o indice de um avaliador da lista.");
		}while (evaluator == null);
		
		return evaluator;
	}
	
	private Evaluation createEvaluation(User reviewer, Integer evaluationScore) {
		
		return null;
	}
	private Integer askEvaluationScore() {
		int evaluationScore;
		do {
			System.out.println("Dê uma nota de -3 a 3:");
			evaluationScore = ApplicationIO.readInteger();
		} while (evaluationScore < -3 || evaluationScore > 3);
		
		return evaluationScore;
	}
	
	@Override
	public String toString() {
		return "Avaliar produtos";
	}

}

