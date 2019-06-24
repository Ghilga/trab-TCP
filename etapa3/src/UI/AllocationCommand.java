package UI;

import java.util.List;

import domain.Database;
import domain.EvaluationGroup;
import domain.Product;
import domain.User;

public class AllocationCommand extends UICommand {

	public static final int MIN_EVALUATORS = 2;
	public static final int MAX_EVALUATORS = 5;
	private EvaluationGroup evalGroup;

	public AllocationCommand() {

	}

	public void execute() {
		int numEvaluators = askNumEvaluators();
		evalGroup = askGroup();

		if (evalGroup.isAllocated()) {
			System.out.println("Grupo j� alocado");
			return;
		} else {
			evalGroup.allocate(numEvaluators);
		}
		
		showReport(evalGroup);
	}
	
	public void showReport(EvaluationGroup evalGroup) {
		printProducts(evalGroup.getOrderedProducts());
		printLog(evalGroup);
	}
	
	public void printLog(EvaluationGroup evalGroup) {
		List<Product> products = evalGroup.getOrderedProducts();
		char logIndex = 'a';
		System.out.println(logIndex++ + ". Iniciando Aloca��o.");
		try {
			for (Product product : products) {
				for (User evaluator : product.getEvaluators()){
					System.out.println(logIndex++ + ". Produto id " + product.getId() + 
										" alocado ao avaliador id " + evaluator.getId());
				}
			}
		} catch (NullPointerException ex) {
			System.out.println(ex.getCause());
		}
		System.out.println(logIndex + ". Fim da Loca��o.\n");
	}
	
	public void printProducts(List<Product> products) {
		System.out.println("Produto \t Avaliador");
		try {
			for (Product product : products) {
				for (User evaluator : product.getEvaluators()){
					System.out.println(product.getId() + "\t\t" + evaluator.getId());
				}
			}
		} catch (NullPointerException ex) {
			System.out.println(ex.getCause());
		}
	}
	

	public int askNumEvaluators() {
		int numEvaluators = 0;
		
		while(numEvaluators < MIN_EVALUATORS || numEvaluators > MAX_EVALUATORS) {
			System.out.println("Quantos membros do grupo ir�o avaliar os produtos? (de 2 a 5)");
			numEvaluators = ApplicationIO.readInteger();	
		}
		return numEvaluators;
	}
	
	@Override
	public String toString() {
		return "Aloca��o de Produtos";
	}
}