package bank.ui.text.command;

import bank.business.AccountOperationService;
import bank.business.domain.Deposit;
import bank.ui.text.BankTextInterface;
import bank.ui.text.UIUtils;

/**
 * @author Ingrid Nunes
 * 
 */
public class DepositCommand extends Command {

	private final AccountOperationService accountOperationService;

	public DepositCommand(BankTextInterface bankInterface,
			AccountOperationService accountOperationService) {
		super(bankInterface);
		this.accountOperationService = accountOperationService;
	}

	@Override
	public void execute() throws Exception {
		Long branch = bankInterface.readBranchId();
		Long accountNumber = bankInterface.readCurrentAccountNumber();
		Long envelope = UIUtils.INSTANCE.readLong("envelope");
		Double amount = UIUtils.INSTANCE.readDouble("amount");

		Deposit deposit = accountOperationService.deposit(bankInterface
				.getOperationLocation().getNumber(), branch, accountNumber,
				envelope, amount);
		
		System.out.println(getTextManager().getText(
					"message.operation.succesfull"));
		System.out.println(getTextManager().getText("deposit") + ": "
				+ deposit.getAmount());

		setStatus(deposit,amount);

	
	}
	
	private void setStatus(Deposit deposit, Double amount) {
		
		if(deposit.getDepositStatus() == Deposit.PENDENTE && amount > 100)
			System.out.println(
					"Status da operacao: PENDENTE\nAguardando confirmacao da agencia para depositar a quantia requisitada");
		
		if(deposit.getDepositStatus() == Deposit.PENDENTE && amount <= 100)
			System.out.println(
					"Status da operacao: PENDENTE\nQuantia disponivel para uso");
		
		else if (deposit.getDepositStatus() == Deposit.FINALIZADA ) {
			//sistema registra estado da transacao como FINALIZADA (na interface textual)
			System.out.println("Status da operacao: FINALIZADA");
		}
		
	}
	
	
	
}