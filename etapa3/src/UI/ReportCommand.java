package UI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import domain.Evaluation;
import domain.EvaluationGroup;
import domain.Product;

public class ReportCommand extends UICommand{
	
	public void printReport() {
		
	}
	
	public void execute() {
		EvaluationGroup group = askGroup();
		List<Product> acceptableProducts = new ArrayList<Product>();
		List<Product> notAcceptableProducts = new ArrayList<Product>();
		
		if (!group.isAllocated())
			System.out.println("Grupo de avaliacao nao alocado");
		else{
			for (Product p : group.getEvaluations().keySet()) {
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
		//Collections.sort(list, compareByScore);
		list.sort(compareByScore);
		
		return list;
	}
	
	public List<Product> sortDecrescent(List<Product> list){
		Comparator<Product> compareByScore = (Product p1, Product p2) -> p1.getScoreAvg().compareTo( p2.getScoreAvg() );
		//Collections.sort(list, compareByScore);
		list.sort(compareByScore.reversed());
		
		return list;
	}
	
	@Override
	public String toString() {
		return "Relat�rio";
	}

}
