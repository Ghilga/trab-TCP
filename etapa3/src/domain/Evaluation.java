package domain;

public class Evaluation {

	private Integer score;
	private EvaluationGroup group;
	private User reviewer;
	private Product product;

	public Evaluation(Integer score, EvaluationGroup group, Product product, User reviewer) {
		this.score = score;
		this.group = group;
		this.product = product;
		this.reviewer = reviewer;
	}
	
	public boolean isDone() {
		return score != null;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public Integer getScore() {
		return this.score;
	}
	
	public User getReviewer() {
		return this.reviewer;
	}
	
	public EvaluationGroup getEvaluationGroup() {
		return this.group;
	}
	
	public Product getProduct() {
		return this.product;
	}
	
	@Override
    public String toString() {

        return product.getName() + "\nNota: " + score + "\nGrupo: " + group.getName() + "\nAvaliador: " + reviewer.getName();
    }

}