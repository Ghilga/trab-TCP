 package domain;

import java.util.List;

public class Report {

	private double gradesAverage;
	private EvaluationGroup selectedGroup;
	private List<Product> acceptableQuality;
	private List<Product> unacceptableQuality;

	public Report(EvaluationGroup evalGroup) {

	}

	public boolean isValidGroup() {
		return false;
	}

	private double calculateAverage() {
		return 0;
	}

	private void createAcceptableProductsList() {
		this.acceptableQuality = null;
	}

	private void createUnacceptableProductsList() {
		this.unacceptableQuality = null;
	}

	public List<Product> getAcceptableProducts() {
		return null;
	}

	public List<Product> getUnacceptableProducts() {
		return null;
	}

}
