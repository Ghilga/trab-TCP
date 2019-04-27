package bank.ui.text.command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bank.business.AccountManagementService;
import bank.business.domain.Deposit;
import bank.ui.text.BankTextInterface;
import bank.ui.text.UIUtils;

public class ConfirmDepositCommand extends Command{
	private final AccountManagementService accountManagementService;
	Map<Integer,Deposit> allAccountsDeposits;
	Map<String,String> allowDepositCommands;

	public ConfirmDepositCommand(BankTextInterface bankInterface,
									AccountManagementService accountManagementService) {
		super(bankInterface);
		this.accountManagementService = accountManagementService;
		allowDepositCommands = new HashMap<>();
		allowDepositCommands.put("A",Deposit.FINALIZADA);
		allowDepositCommands.put("C",Deposit.CANCELADA);
	}

	@Override
	public void execute() throws Exception {
		allAccountsDeposits = new HashMap<>();
		List<Deposit> allDeposits = accountManagementService.getAllAccountsDeposits();
		for (int i=0; i < allDeposits.size(); i++) {		//Deposit deposit : allDeposits
			allAccountsDeposits.put(i+1, allDeposits.get(i));
		}
		
		printDeposits(allDeposits);
		Deposit selectedDeposit = allAccountsDeposits.get(UIUtils.INSTANCE.readInteger("message.choose.deposit"));
		printOption();
		String finalStatus = null;
		while (finalStatus == null){
			try {
				finalStatus = allowDepositCommands.get(UIUtils.INSTANCE.readString("message.choose.status"));
				if(finalStatus != Deposit.FINALIZADA || finalStatus != Deposit.CANCELADA) 
					throw new Exception();
			} catch (Exception e) {
				System.out.println("Opcao invalida");
			}
		}
		selectedDeposit.setDepositStatus(finalStatus);
		
		if(finalStatus == Deposit.CANCELADA && selectedDeposit.getAmount() > 100) {
			selectedDeposit.setDepositStatus(finalStatus); //finalStatus = CANCELADA
			
		} else if(finalStatus == Deposit.CANCELADA && selectedDeposit.getAmount() <= 100) {
			selectedDeposit.setDepositStatus(finalStatus); //finalStatus = CANCELADA
			selectedDeposit.getAccount().depositDenied(selectedDeposit.getAmount());
			
		} else if(finalStatus == Deposit.FINALIZADA && selectedDeposit.getAmount() <= 100) {
			selectedDeposit.setDepositStatus(finalStatus); //finalStatus = FINALIZADA
			
		} else {	
			selectedDeposit.getAccount().depositConfirmed(selectedDeposit.getAmount());
			selectedDeposit.setDepositStatus(finalStatus); //finalStatus = FINALIZADA
		}
		
	}
	
	private void printDeposits(List<Deposit> allDeposits) {
		System.out.println("N \tConta \tValor \t\t\tEstado");
		for (int i=0; i < allDeposits.size(); i++) {
			System.out.println(
				i+1 + " - " + "\t" +
				allDeposits.get(i).getAccount().getId().getNumber() + "\t" + 
				allDeposits.get(i).getAmount() + "\t" + 
				allDeposits.get(i).getDepositStatus()
				);			
		}
	}
	
	private void printOption() {
		System.out.println("A - Autorizar deposito");
		System.out.println("C - Cancelar deposito");
	}
	
	
}
