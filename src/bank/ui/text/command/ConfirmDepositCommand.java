package bank.ui.text.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bank.business.AccountManagementService;
import bank.business.BusinessException;
import bank.business.domain.Deposit;
import bank.ui.text.BankTextInterface;
import bank.ui.text.UIUtils;

public class ConfirmDepositCommand extends Command{
	private final AccountManagementService accountManagementService;
	Map<Integer,Deposit> pendingDeposits;
	Map<String,String> allowDepositCommands;

	public ConfirmDepositCommand(BankTextInterface bankInterface,
									AccountManagementService accountManagementService) {
		super(bankInterface);
		this.accountManagementService = accountManagementService;
		allowDepositCommands = new HashMap<>();
		allowDepositCommands.put("A",Deposit.FINALIZADA);
		allowDepositCommands.put("C",Deposit.CANCELADA);
		allowDepositCommands.put("E","Sair");
	}

	@Override
	public void execute() throws Exception {
		List<Deposit> pendingDepositsList = getPendingDeposits();
		if(pendingDepositsList.isEmpty()) {
			System.out.println("Não há depósitos pendentes");
			return;
		}
		Deposit selectedDeposit = null;
		int option;
		do {
			printDeposits(pendingDepositsList);
			option = UIUtils.INSTANCE.readInteger("message.choose.deposit");
		} while(!pendingDeposits.containsKey(option));
		
		selectedDeposit = pendingDeposits.get(option);
		printOption();
		
		String finalStatus = null;
		do{
			try {
				finalStatus = allowDepositCommands.get(UIUtils.INSTANCE.readString(null));
				if(!allowDepositCommands.containsValue(finalStatus)) 
					throw new Exception();
			} catch (Exception e) {
				System.out.println("Opcao invalida");
			}
		} while (!allowDepositCommands.containsValue(finalStatus));
		
		if(finalStatus == "Sair") {
			return;
		}
		
		else if(finalStatus == Deposit.CANCELADA) {
			if(selectedDeposit.getAmount() > 100) {
				selectedDeposit.setDepositStatus(finalStatus); //finalStatus = CANCELADA
			} 
			else {	//amount <= 100
				selectedDeposit.setDepositStatus(finalStatus); //finalStatus = CANCELADA
				selectedDeposit.getAccount().depositDenied(selectedDeposit.getAmount());
			}
		} 
		else if(finalStatus == Deposit.FINALIZADA) {
			if(selectedDeposit.getAmount() > 100) {
				selectedDeposit.getAccount().depositConfirmed(selectedDeposit.getAmount());
				selectedDeposit.setDepositStatus(finalStatus); //finalStatus = FINALIZADA
			} 
			else {	//amount <= 100
		 		selectedDeposit.setDepositStatus(finalStatus); //finalStatus = FINALIZADA
		 	}
		}
		
	}
	
	private void printDeposits(List<Deposit> allDeposits) {
		System.out.println("\nN \tConta \tValor \t\t\tEstado");
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
		System.out.println("\nOpções (ou E para sair)");
		System.out.println("A - Autorizar deposito");
		System.out.println("C - Cancelar deposito");
		System.out.println("Escolha uma opção: ");
	}
	
	private List<Deposit> getPendingDeposits(){
		pendingDeposits = new HashMap<>();
		List<Deposit> pendingDepositsList = new ArrayList<>();
		List<Deposit> allDeposits = null;
		
		try {
			allDeposits = accountManagementService.getAllAccountsDeposits();
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		
		int key = 1;
		for (int i=0; i < allDeposits.size(); i++) {
			if(allDeposits.get(i).getDepositStatus() == Deposit.PENDENTE) {
				pendingDeposits.put(key++, allDeposits.get(i));
				pendingDepositsList.add(allDeposits.get(i));
			}
		}
		
		return pendingDepositsList;
	}
	
}
