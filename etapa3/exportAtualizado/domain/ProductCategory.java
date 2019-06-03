package domain;

public class ProductCategory {

	private String name;

	private User evaluator;

	private Product product;

	public ProductCategory(String name) {
		super();
		this.name = name;
		this.evaluator = null;
		this.product = null;
	}
}
