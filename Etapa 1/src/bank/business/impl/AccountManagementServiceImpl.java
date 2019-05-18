/*
 * Created on 5 Jan 2014 00:51:19 
 */
package bank.business.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bank.business.AccountManagementService;
import bank.business.BusinessException;
import bank.business.domain.Branch;
import bank.business.domain.Client;
import bank.business.domain.CurrentAccount;
import bank.business.domain.Deposit;
import bank.business.domain.Employee;
import bank.business.domain.OperationLocation;
import bank.data.Database;
import bank.util.RandomString;

/**
 * @author Ingrid Nunes
 * 
 */
public class AccountManagementServiceImpl implements AccountManagementService {

	private final Database database;
	private RandomString random;

	public AccountManagementServiceImpl(Database database) {
		this.database = database;
		this.random = new RandomString(8);
	}

	@Override
	public CurrentAccount createCurrentAccount(long branch, String name,
			String lastName, int cpf, Date birthday, double balance)
			throws BusinessException {
		OperationLocation operationLocation = database
				.getOperationLocation(branch);
		if (operationLocation == null || !(operationLocation instanceof Branch)) {
			throw new BusinessException("exception.invalid.branch");
		}

		Client client = new Client(name, lastName, cpf, random.nextString(),
				birthday);
		CurrentAccount currentAccount = new CurrentAccount(
				(Branch) operationLocation,
				database.getNextCurrentAccountNumber(), client, balance);

		database.save(currentAccount);

		return currentAccount;
	}

	@Override
	public Employee login(String username, String password)
			throws BusinessException {
		Employee employee = database.getEmployee(username);

		if (employee == null) {
			throw new BusinessException("exception.inexistent.employee");
		}
		if (!employee.getPassword().equals(password)) {
			throw new BusinessException("exception.invalid.password");
		}

		return employee;
	}
	
	@Override
	public List<Deposit> getAllAccountsDeposits() throws BusinessException {
		Collection<CurrentAccount> currentAccounts = this.database.getAllCurrentAccounts();
		List<Deposit> allDeposits = new ArrayList<Deposit>();
		for (CurrentAccount account : currentAccounts.toArray(new CurrentAccount[0])) {
			for(Deposit accountDeposits : account.getDeposits()) {
				allDeposits.add(accountDeposits);
			}
		}
		return allDeposits;
	}	
	
	public List<Deposit> getPendingDepositsList() {
		
		List<Deposit> pendingDepositsList = new ArrayList<>();
		List<Deposit> allDeposits = null;
		
		try {
			allDeposits = this.getAllAccountsDeposits();
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		
		for (int i=0; i < allDeposits.size(); i++) {
			if(allDeposits.get(i).getDepositStatus() == Deposit.PENDENTE) {
				pendingDepositsList.add(allDeposits.get(i));
			}
		}
		
		return pendingDepositsList;
	}

	public HashMap<Integer, Deposit> getPendingDepositsMap() {
		
		HashMap<Integer,Deposit> pendingDeposits;
		
		pendingDeposits = new HashMap<>();
		List<Deposit> allDeposits = null;
		
		try {
			allDeposits = this.getAllAccountsDeposits();
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		
		int key = 1;
		for (Deposit deposit : allDeposits) {
			if(deposit.getDepositStatus() == Deposit.PENDENTE) {
				pendingDeposits.put(key++, deposit);
			}
		}
		
		return pendingDeposits;
	}
	
}