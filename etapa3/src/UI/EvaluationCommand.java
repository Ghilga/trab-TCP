package UI;

import domain.Database;
import domain.EvaluationGroup;
import domain.Product;
import domain.User;

public class EvaluationCommand extends UICommand{
	
	public void execute() {
		Product productInEvaluation;
		System.out.println("Digite o nome de um produto da lista abaixo: ");
		do {
			displayProducts(Database.getProducts());
			String productName = UI.scanner.nextLine();
			productInEvaluation = Database.findProduct(productName);
			if (productInEvaluation == null)
				System.out.println("Produto invalido, digite o nome de um produto da lista.");
		}while (productInEvaluation == null);
	
		EvaluationGroup group = productInEvaluation.getGroup();
		User evaluator;
		
		do {
			displayUsers(group.getMembers());
			String evaluatorName = UI.scanner.nextLine();
			evaluator = group.findUser(evaluatorName);
			if (productInEvaluation == null)
				System.out.println("Produto invalido, digite o nome de um produto da lista.");
		}while (productInEvaluation == null);
	
	}

}
