package UI;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.Database;
import domain.EvaluationGroup;
import domain.Product;
import domain.User;

public class AllocationCommand extends UICommand {

	public static final int MIN_EVALUATORS = 2;
	public static final int MAX_EVALUATORS = 5;
	private List<User> candidates;
	private List<Product> productsToAllocate;
	private EvaluationGroup evalGroup;
	private Map<Integer, EvaluationGroup> groupsMenu;

	public AllocationCommand() {
		initializeGroupsMap();
		
	}

	public void execute() {
		int numEvaluators = askNumEvaluators();
		evalGroup = askGroup();

		if (evalGroup.isAllocated()) {
			System.out.println("Grupo já alocado");
			return;
		} else {
			for (int i = 0; i < numEvaluators; i++) {
				productsToAllocate = evalGroup.getOrderedProducts();
				try {
					while (!productsToAllocate.isEmpty()) {
						Product selectedProduct = productsToAllocate.get(i);
						candidates = evalGroup.getOrderedCandidateReviewers(selectedProduct);
						User reviewer = candidates.get(0);
						evalGroup.addEvaluation(selectedProduct, reviewer);
						productsToAllocate.remove(selectedProduct);
						
						Database.saveEvalGroup(evalGroup);
						showReport(evalGroup);
					}
				} catch (NullPointerException ex) {
					System.out.println(ex.getCause());
				}
			}
		}
		
		showReport(evalGroup);
	}
	
	private void initializeGroupsMap() {
		groupsMenu = new HashMap<>();
		List<EvaluationGroup> groups = Database.getEvalGroups();

		for (int i = 0; i < groups.size(); i++) {
			groupsMenu.put(i + 1, groups.get(i));
		}
	}
	
	public void showReport(EvaluationGroup evalGroup) {
		printProducts(evalGroup.getOrderedProducts());
		printLog(evalGroup);
	}
	
	public void printLog(EvaluationGroup evalGroup) {
		List<Product> products = evalGroup.getOrderedProducts();
		char logIndex = 'a';
		System.out.println(logIndex++ + ". Iniciando Alocação.");
		try {
			for (Product product : products) {
				for (User evaluator : product.getEvaluators()){
					System.out.println(logIndex++ + ". Produto id " + product.getId() + 
										"alocado ao avaliador id " + evaluator.getId());
				}
			}
		} catch (NullPointerException ex) {
			System.out.println(ex.getCause());
		}
		System.out.println(logIndex + ". Fim da Locação.");
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
	
	public EvaluationGroup askGroup() {
		EvaluationGroup selectedGroup = null;
		
		while(selectedGroup == null) {
			displayEvalGroups(Database.getEvalGroups());
			
			System.out.println("Escolha o grupo para alocar os produtos: ");
			selectedGroup = groupsMenu.get(ApplicationIO.readInteger());
		}
		return selectedGroup;
	}

	public int askNumEvaluators() {
		int numEvaluators = 0;
		
		while(numEvaluators < MIN_EVALUATORS || numEvaluators > MAX_EVALUATORS) {
			System.out.println("Quantos membros  do grupo irão avaliar os produtos? (de 2 a 5)");
			numEvaluators = ApplicationIO.readInteger();	
		}
		return numEvaluators;
	}
	
	@Override
	public String toString() {
		return "Alocação de Produtos";
	}
}