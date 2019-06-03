package domain;

import java.util.List;

public class Report {

	private double gradesAverage;

	private EvaluationGroup selectedGroup;

	private Product[] acceptableQuality;

	private Product[] unacceptableQuality;

	public Report(EvaluationGroup evalGroup) {

	}

	public boolean isValidGroup() {
		return false;
	}

	private double calculateAverage() {
		return 0;
	}

	private void createAcceptableProductsList() {

	}

	private void createUnacceptableProductsList() {

	}

	public List<Product> getAcceptableProducts() {
		return null;
	}

	public List<Product> getUnacceptableProducts() {
		return null;
	}

}
