package bank.ui.text.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bank.business.AccountManagementService;
import bank.business.BusinessException;
import bank.business.domain.Deposit;
import bank.business.impl.AccountManagementServiceImpl;
import bank.ui.text.BankTextInterface;
import bank.ui.text.UIUtils;

public class ConfirmDepositCommand extends Command{
	private final AccountManagementService accountManagementService;
	private Map<Integer,Deposit> pendingDeposits;
	private Map<String,String> allowDepositCommands;

	public ConfirmDepositCommand(BankTextInterface bankInterface,
									AccountManagementService accountManagementService) {
		super(bankInterface);
		this.accountManagementService = accountManagementService;
		this.pendingDeposits = new HashMap<>();
		allowDepositCommands = new HashMap<>();
		allowDepositCommands.put("A",Deposit.FINALIZADA);
		allowDepositCommands.put("C",Deposit.CANCELADA);
		allowDepositCommands.put("E","Sair");
	}

	@Override
	public void execute() throws Exception {
		List<Deposit> pendingDepositsList = accountManagementService.getPendingDepositsList();
		this.pendingDeposits = accountManagementService.getPendingDepositsMap();
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
		
		setFinalStatus(selectedDeposit,finalStatus);
		
		
	}
	
	public void setFinalStatus(Deposit selectedDeposit, String finalStatus) {
		if(finalStatus == "Sair") {
			return;
		}
		else if(finalStatus == Deposit.CANCELADA) {
			if(selectedDeposit.getAmount() > 100) {
				selectedDeposit.setDepositStatus(finalStatus); //finalStatus = CANCELADA
			} 
			else {	//amount <= 100
				selectedDeposit.setDepositStatus(finalStatus); //finalStatus = CANCELADA
				try {
					selectedDeposit.getAccount().depositDenied(selectedDeposit.getAmount());
				} catch (BusinessException e) {
					e.printStackTrace();
				}
			}
		} 
		else if(finalStatus == Deposit.FINALIZADA) {
			if(selectedDeposit.getAmount() > 100) {
				try {
					selectedDeposit.getAccount().depositConfirmed(selectedDeposit.getAmount());
				} catch (BusinessException e) {
					e.printStackTrace();
				}
				selectedDeposit.setDepositStatus(finalStatus); //finalStatus = FINALIZADA
			} 
			else {	//amount <= 100
		 		selectedDeposit.setDepositStatus(finalStatus); //finalStatus = FINALIZADA
		 	}
		}
	}
	
	public void printDeposits(List<Deposit> allDeposits) {
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
	
	public void printOption() {
		System.out.println("\nOpções (ou E para sair)");
		System.out.println("A - Autorizar deposito");
		System.out.println("C - Cancelar deposito");
		System.out.println("Escolha uma opção: ");
	}
	
}
