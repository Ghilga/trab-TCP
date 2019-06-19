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
			groupsMenu.put(i+1, groups.get(i));
		}
	}
	
	public void execute() {
		printGroups();
		int numEvaluators = askNumEvaluators();
		evalGroup = askGroup();
		if (evalGroup.isAllocated()) {
			System.out.println("Grupo já alocado");
			return;
		}
		else {
			for (int i=0; i<numEvaluators; i++) {
				productsToAllocate = evalGroup.getOrderedProducts();
				candidates = evalGroup.getOrderedCandidateReviewers();
				//--------------------
			}
		}
	}
	
	public EvaluationGroup askGroup() {
		System.out.println("Escolha o grupo para alocar os produtos: ");	
		return groupsMenu.get(UI.scanner.nextInt());
	}
	
	
	public int askNumEvaluators() {
		System.out.println("Quantos membros do grupo irão avaliar os produtos? ");
		return UI.scanner.nextInt();
	}
	
	public List<User> chooseEvaluators(){
		return null;
	}
	
	public void printGroups () {
		for (int i = 1; i <= groupsMenu.size(); i++)
		System.out.println(i + " - " + groupsMenu.get(i).getName());
	}
}