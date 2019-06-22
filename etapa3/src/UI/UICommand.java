package UI;

import java.util.List;

import domain.Product;
import domain.User;

public abstract class UICommand {
	UI ui;
	
	public UICommand() {
		
	}
	
	public abstract void execute();
	
	public void displayGrades() {
		
	}
	
	public void displayEvalGroups() {
		
	}
	
	public void displayProducts(List<Product> products) {
		
	}
	
	public void displayUsers(List<User> users) {
		
	}
	

}
