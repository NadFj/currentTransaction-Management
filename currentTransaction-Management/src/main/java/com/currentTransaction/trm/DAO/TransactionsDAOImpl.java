package com.currentTransaction.trm.DAO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.currentTransaction.trm.model.Transaction;
import com.currentTransaction.trm.model.TransactionDTO;

public class TransactionsDAOImpl implements TransactionsDAO {

	
	Map<Integer,Transaction> TransactionInfos = new HashMap<Integer ,Transaction>();
	@Override
	public List<Transaction> getAccountTransactions(TransactionDTO model) {
		
		List<Transaction> transactionsLst =new ArrayList<Transaction>() ;
		// TODO Auto-generated method stub
		// we should implement Database connection and query 
		/*		
		Map<Integer,Transaction> TransactionInfos = new HashMap<Integer ,Transaction>();
		
		 System.out.println("create ccount======");
		// here we have to connect to the DB but here we make it statiSc data 
		 Transaction transact1 = new Tt(1,customerId,customerName,customerSurName,initialCredit,"Debit")	;
		String newAccount = "The client has a new Account"+account.toString();
*/
		int customerId =model.getCustomerId();
		System.out.println("custom id DTO"+ customerId);
		//System.out.println("custom name"+ model.getAttribute("customerName"));
//		String customerName = model.getAccountDTO().getCustomerName();
	//	String customerSurName = model.getAccountDTO().getCustomerSurName();
		BigDecimal initialCredit = model.getAmount();
		int accountId = model.getAccountId();
		
//		public @ResponseBody List<Account> createAccount() {
		 System.out.println("create Transaction======");
	//	List<Account> lstAccount = new ArrayList<Account>();
		 if(initialCredit != new BigDecimal(0))
		 {
			// Account account = new Account(1,customerId,customerName,customerSurName,initialCredit,"Debit")	;
			 BigDecimal balance = initialCredit.add(new BigDecimal(20000));
			 Transaction trans = new Transaction(1, initialCredit,balance , customerId,accountId,"");
			 TransactionInfos.put(accountId, trans);

		 }
		 
		transactionsLst.add(TransactionInfos.get(accountId));
		return null;
	}

}
