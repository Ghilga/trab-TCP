package UI;


import domain.Database;
import domain.Evaluation;
import domain.EvaluationGroup;
import domain.Product;
import domain.User;

public class EvaluationCommand extends UICommand{
	
	public EvaluationCommand() {
		
	}
	
	public void execute() {
		Product productInEvaluation;
		User evaluator;
		int score;
		
		productInEvaluation = askProduct();
		evaluator = askEvaluator(productInEvaluation);
		score = askGrade();
		
		Evaluation eval = new Evaluation(score, productInEvaluation.getGroup(), productInEvaluation, evaluator);
		Database.saveEvaluation(eval);
		System.out.println(eval);
		
	
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

