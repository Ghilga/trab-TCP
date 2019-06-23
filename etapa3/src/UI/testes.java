package UI;

import domain.Database;

public class testes {

	public static void main(String[] args) {
		Database.initialize();
		System.out.println(Database.getEvalGroups().get(0));

	}

}
