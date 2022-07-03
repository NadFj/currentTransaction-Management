package com.currentTransaction.trm.DAO;

import java.util.List;

import com.currentTransaction.trm.model.Transaction;
import com.currentTransaction.trm.model.TransactionDTO;

public interface TransactionsDAO {
	
//	List<Transaction> getAccountTransactions();

	List<Transaction> getAccountTransactions(TransactionDTO transDto);
	

}
