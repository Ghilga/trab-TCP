package UI;


import java.util.List;

import domain.Database;
import domain.Evaluation;
import domain.Product;
import domain.User;

public class EvaluationCommand extends UICommand{
	
	public EvaluationCommand() {
		
	}
	
	public void execute() {
		
		Product productInEvaluation;
		displayProducts(Database.getProducts());
		do {
			productInEvaluation = askProduct();
			if (!productInEvaluation.hasEvaluators())
				System.out.println("O produto selecionado ainda não foi alocado a nenhum avaliador!");
			
		} while(!productInEvaluation.hasEvaluators());
		
		User evaluator = askEvaluator(productInEvaluation);
		int score = askGrade();
		productInEvaluation.addScore(evaluator, score);
		
		Evaluation eval = new Evaluation(score, productInEvaluation.getGroup(), productInEvaluation, evaluator);
		Database.saveEvaluation(eval);
		System.out.println(eval);
	}
	
	
	private Product askProduct() {
		Product product;
		int initialIndex = 1;
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
		
		List<User> evaluators = product.getEvaluators();
		displayUsers(evaluators);
		
		int initialIndex = 1;
		int evaluatorIndex;
		
		do {
			evaluatorIndex = ApplicationIO.readInteger();
			
			if (evaluatorIndex < initialIndex || evaluatorIndex > evaluators.size())
				System.out.println("Avaliador invalido, digite o indice de um avaliador da lista.");
			
		}while (evaluatorIndex < initialIndex || evaluatorIndex > evaluators.size());

		return evaluators.get(evaluatorIndex - initialIndex);
	}
	
	private int askGrade() {
		int score;
		System.out.println("Selecione uma nota para o produto de -3 a 3: ");
		do {
			score = ApplicationIO.readInteger();
			if (score < -3 || score > 3)
				System.out.println("a nota deve estar entre -3 e 3");
		}while (score < -3 || score > 3);
		return score;
	}
	
	@Override
	public String toString() {
		return "Avaliar produtos";
	}

}

