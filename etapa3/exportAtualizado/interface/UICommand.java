package interface;

import java.util.List;
import java.util.Map;
import domain.User;

public abstract class UICommand {

	public UICommand() {

	}

	public abstract void execute();

	public void displayGrades(List<ProductCategory> grades) {

	}

	public void displayEvalGroups(Map<Product,List<String>> groups) {

	}

	public void displayProducts(List<Product> products) {

	}

	public void displayUsers(User users) {

	}

}
