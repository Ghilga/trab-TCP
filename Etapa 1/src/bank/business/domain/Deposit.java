package bank.business.domain;

/**
 * @author Ingrid Nunes
 * 
 */
public class Deposit extends Transaction {

	public static final String PENDENTE = "Pendente";
	public static final String FINALIZADA = "Finalizada";
	public static final String CANCELADA = "Cancelada";
	private long envelope;
	private String depositStatus;

	public Deposit(OperationLocation location, CurrentAccount account,
			long envelope, double amount) {
		super(location, account, amount);
		this.envelope = envelope;
		if(location instanceof Branch) {
			this.depositStatus = FINALIZADA;
		} 
		else if(location instanceof ATM){
			this.depositStatus = PENDENTE;
		}
		
	}

	/**
	 * @return the envelope
	 */
	public long getEnvelope() {
		return envelope;
	}
	/**
	 * 
	 * @param status
	 * 			sets the deposit status
	 */
	public void setDepositStatus(String depositStatus) {
		this.depositStatus = depositStatus;
	}
	/**
	 * 
	 * @return deposit status
	 */
	public String getDepositStatus() {
		return depositStatus;
	}
	
}
