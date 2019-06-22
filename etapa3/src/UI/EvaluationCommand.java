package UI;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.Database;
import domain.EvaluationGroup;
import domain.Product;
import domain.User;

public class EvaluationCommand extends UICommand{
	
	public EvaluationCommand() {
		
	}
	
	public void execute() {
		Product productInEvaluation;
		User evaluator;
		
		productInEvaluation = askProduct();
		System.out.println("produto escolhido: " + productInEvaluation.getName());
		evaluator = askEvaluator(productInEvaluation);
		System.out.println("avaliador escolhido escolhido: " + evaluator.getName());
		
	
	}
	
	
	private Product askProduct() {
		Product product;
		int initialIndex = 1;
		displayProducts(Database.getProducts());
		System.out.println("Escolha um produto da lista acima: ");
		do {
			
			int selectedIndex = ApplicationIO.readInteger() - initialIndex;
			product = Database.getProduct(selectedIndex);
			if (product == null)
				System.out.println("Produto invalido, digite o indice de um produto da lista.");
		}while (product == null);
		
		return product;
	}
	
	private User askEvaluator(Product product) {
		
		EvaluationGroup group = product.getGroup();
		int initialIndex = 1;
		displayUsers(group.getMembers());
		
		User evaluator;
		
		do {
			
			int evaluatorIndex = ApplicationIO.readInteger() - initialIndex;
			evaluator = group.getUser(evaluatorIndex);
			if (evaluator == null)
				System.out.println("Avaliador invalido, digite o indice de um avaliador da lista.");
		}while (evaluator == null);
		
		return evaluator;
	}
	
	@Override
	public String toString() {
		return "Avaliar produtos";
	}

}

