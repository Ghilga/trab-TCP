package UI;

import java.util.List;

import domain.Database;
import domain.EvaluationGroup;

public class testes {

	public static void main(String[] args) {
		Database.initialize();
		List<EvaluationGroup> e = Database.getEvalGroups();
		System.out.println(e.get(0).getName());
		e.remove(0);
		System.out.println(e.get(0).getName());
		

	}

}
