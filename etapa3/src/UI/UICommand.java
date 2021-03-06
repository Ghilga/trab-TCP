package UI;

import java.util.List;

import domain.Database;
import domain.Evaluation;
import domain.EvaluationGroup;
import domain.Product;
import domain.User;

public abstract class UICommand {
	
	public UICommand() {
		
	}
	
	public abstract void execute();
	
	public void displayEvaluations() {

	}
	
	public void displayEvalGroups(List<EvaluationGroup> evalGroups) {
		for (int i = 0; i < evalGroups.size(); i++)
			System.out.println(i+1 + " - " + evalGroups.get(i).getName());
	}
	
	public void displayProducts(List<Product> products) {
		for (int i = 0; i < products.size(); i++)
			System.out.println(i+1 + " - " + products.get(i).getName());
	}
	
	public void displayUsers(List<User> users) {
		for (int i = 0; i < users.size(); i++)
			System.out.println(i+1 + " - " + users.get(i).getName());
	}
	
	public void displayEvaluations(List<Evaluation> evaluations) {
		for (int i = 0; i < evaluations.size(); i++)
			System.out.println(i+1 + " - " + evaluations.get(i));
	}
	
	public EvaluationGroup askGroup() {
		EvaluationGroup selectedGroup = null;
		
		while(selectedGroup == null) {
			displayEvalGroups(Database.getEvalGroups());
			int initialIndex = 1;
			System.out.println("Escolha um grupo: ");
			selectedGroup = Database.getEvalGroup((ApplicationIO.readInteger())-initialIndex);
		}
		return selectedGroup;
	}
	

}
