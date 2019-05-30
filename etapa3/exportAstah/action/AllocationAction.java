package action;

import java.util.List;
import domain.EvaluationGroup;
import domain.User;
import domain.Product;

public class AllocationAction extends ApplicationAction {

	private int evaluatorsPerProduct;

	private List<Product> allocationProducts;

	public AllocationAction(EvaluationGroup evalGroup, int evalPerProd) {

	}

	public EvaluationGroup getEvalGroup(int evalGroupID) {
		return null;
	}

	/**
	 * Ordena em ordem crescente de produtos alocados ao candidato. Id é usado como critério de desempate (menor id vem antes de maior id).
	 */
	public List<User> reorderCandidatesList(List<User> candidates) {
		return null;
	}

	/**
	 * Cria uma classe Grade para ser adicionada na Database
	 */
	public void assignProduct(User member, Product product) {

	}

	public void writeChanges() {

	}

	public void sortAllocatedProducts() {

	}

	public void createProdAllocationList() {

	}

	/**
	 * Seleciona membros do grupo como candidatos com os seguintes criterios:
	 * 1 - solicitante ou candidato de mesmo estados que o solicitante sao excluidos
	 * 2 - categoria de interesse o membro não inclui o produto selecionado é excluido
	 * 3 - membro ja alocado para o mesmo produto é excluido
	 * 
	 * Obs: produto de entrada é o primeiro da lista de produtos a serem alocados.
	 */
	public List<User> selectCandidates(Product product, EvaluationGroup evalGroup) {
		return null;
	}

	public String getReport(EvaluationGroup evalGroup) {
		return null;
	}

	public void execute() {

	}

}
