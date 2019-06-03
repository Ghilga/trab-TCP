package domain;
public class Evaluation {

	private Integer score;

	private EvaluationGroup group;

	private User reviwer;

	private Product product;

	Evaluation(Integer score, EvaluationGroup group, Product product, User reviwer) {
		super();
		this.score = score;
		this.group = group;
		this.product = product;
		this.reviwer = reviwer;
	}
	
	Evaluation(EvaluationGroup group, Product product, User reviwer) {
		super();
		this.score = null;
		this.group = group;
		this.product = product;
		this.reviwer = reviwer;
	}

	public boolean isDone() {
		return false;
	}

	public void setScore(int score) {

	}

}
