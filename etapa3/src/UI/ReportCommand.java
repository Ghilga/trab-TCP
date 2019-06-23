package UI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import domain.Database;
import domain.Evaluation;
import domain.EvaluationGroup;
import domain.Product;

public class ReportCommand extends UICommand{
	
	public void printReport() {
		
	}
	
	public void execute() {
		displayEvalGroups(Database.getEvalGroups());
		EvaluationGroup group = askGroup();
		List<Product> acceptableProducts = new ArrayList<Product>();
		List<Product> notAcceptableProducts = new ArrayList<Product>();
		if (!group.isAllocated())
			System.out.println("grupo de avaliacao nao alocado");
		else{
			for (Map.Entry<Product , List<Evaluation>> entry : group.getEvaluations().entrySet()) {
				System.out.println("oi");
				Product p = entry.getKey();
				System.out.println("x" + p);
				if (p.isAcceptable())
					acceptableProducts.add(p);
				else
					notAcceptableProducts.add(p);
			}
			
		}
		System.out.println("Produtos de qualidade aceitavel: ");
		displayProducts(acceptableProducts);
		System.out.println("Produtos de qualidade nao aceitavel: ");
		displayProducts(notAcceptableProducts);
		
	}
	
	public List<Product> sortCrescent(List<Product> list){
		Comparator<Product> compareByScore = (Product p1, Product p2) -> p1.getScoreAvg().compareTo( p2.getScoreAvg() );
		Collections.sort(list, compareByScore);
		
		return list;
	}
	
	@Override
	public String toString() {
		return "Relatório";
	}

}
