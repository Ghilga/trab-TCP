package UI;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.Database;
import domain.EvaluationGroup;
import domain.Product;
import domain.User;

public class AllocationCommand extends UICommand {

	private List<User> candidates;
	private List<Product> productsToAllocate;
	private EvaluationGroup evalGroup;
	private Map<Integer, EvaluationGroup> groupsMenu;

	public AllocationCommand() {

		groupsMenu = new HashMap<>();
		List<EvaluationGroup> groups = Database.getEvalGroups();
		int groupsListSize = Database.getEvalGroups().size();

		for (int i = 0; i < groupsListSize; i++) {
			groupsMenu.put(i + 1, groups.get(i));
		}
	}

	public void execute() {
		printGroups();
		int numEvaluators = askNumEvaluators();
		evalGroup = askGroup();

		if (evalGroup.isAllocated()) {
			System.out.println("Grupo já alocado");
			return;
		} else {
			for (int i = 0; i < numEvaluators; i++) {
				productsToAllocate = evalGroup.getOrderedProducts();

				while (!productsToAllocate.isEmpty()) {
					Product selectedProduct = productsToAllocate.get(i);
					candidates = evalGroup.getOrderedCandidateReviewers(selectedProduct);
					User reviewer = candidates.get(0);
					evalGroup.addEvaluation(selectedProduct, reviewer);
					productsToAllocate.remove(selectedProduct);
					Database.saveEvalGroup(evalGroup);
					showReport(evalGroup);
				}
			}

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
		for (Product product : products) {
			for (User evaluator : product.getEvaluators()){
				System.out.println(logIndex++ + ". Produto id " + product.getId() + 
									"alocado ao avaliador id " + evaluator.getId());
			}
		}
		System.out.println(logIndex + "Fim da Locação.");
	}
	
	public void printProducts(List<Product> products) {
		System.out.println("Produto \t Avaliador");
		for (Product product : products) {
			for (User evaluator : product.getEvaluators()){
				System.out.println(product.getId() + "\t\t" + evaluator.getId());
			}
		}
	}
	
	public void printGroups() {
		for (int i = 1; i <= groupsMenu.size(); i++)
			System.out.println(i + " - " + groupsMenu.get(i).getName());
	}

	public EvaluationGroup askGroup() {
		System.out.println("Escolha o grupo para alocar os produtos: ");
		return groupsMenu.get(UI.scanner.nextInt());
	}

	public int askNumEvaluators() {
		System.out.println("Quantos membros do grupo irão avaliar os produtos? ");
		return UI.scanner.nextInt();
	}
}