package domain;

public class Evaluation {

	private Integer score;
	private EvaluationGroup group;
	private User reviwer;
	private Product product;

	public Evaluation(Integer score, EvaluationGroup group, Product product, User reviwer) {
		this.score = score;
		this.group = group;
		this.product = product;
		this.reviwer = reviwer;
	}
	
	public Evaluation(EvaluationGroup group, Product product, User reviwer) {
		this.score = null;
		this.group = group;
		this.product = product;
		this.reviwer = reviwer;
	}
	public boolean isDone() {
		return score != null;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public Integer getScore() {
		return score;
	}

}