package com.currentTransaction.trm.controllers;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.currentTransaction.trm.model.Transaction;
import com.currentTransaction.trm.model.TransactionDTO;

@Controller
@RequestMapping("/tr/TransactMgt")
public class TransactionController {

	Map<Integer, Transaction> customerAccountInfos = new HashMap<Integer, Transaction>();

	@RequestMapping(value = "/showTransactions", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_XML_VALUE })
	public @ResponseBody Transaction[] showTransactionAccountList(HttpServletRequest request) {
		String id = (String) request.getParameter("accountId");
		System.out.println("id" + id);
		// same customer but different account
		Transaction tr1 = new Transaction(1, new BigDecimal(120), new BigDecimal(2120), 1, 1, "");
		customerAccountInfos.put(1, tr1);
		Transaction tr1_2 = new Transaction(2, new BigDecimal(100), new BigDecimal(2220), 6, 2, "");
		customerAccountInfos.put(2, tr1_2);
		Transaction tr1_3 = new Transaction(3, new BigDecimal(100), new BigDecimal(2220), 5, 3, "");
		customerAccountInfos.put(3, tr1_3);
		// another account and customer than 1
		Transaction tr2 = new Transaction(4, new BigDecimal(100), new BigDecimal(2220), 4, 4, "");
		customerAccountInfos.put(4, tr2);
		Transaction[] transactions = null;
		System.out.println("get Id = " + customerAccountInfos.size());
		if (request.getParameter("accountId") != null) {
			int acountId = Integer.parseInt(id);
			Transaction trReturnId = customerAccountInfos.get(acountId);
			System.out.println("get Id returned = " + customerAccountInfos.get(acountId));
			System.out.println("get Id returned = " + trReturnId.toString());
			transactions = new Transaction[] { trReturnId };
		} else {
			transactions = new Transaction[] { tr1, tr1_2, tr1_3, tr2 };

		}
		/*
		 * model.getAttribute("accountId"); TransactionDTO trDto = new TransactionDTO();
		 * System.out.
		 * println("lstAccountTransaction =====model.getAttribute(\"accountId\")====="
		 * +model.getAttribute("accountId")); // write the db List<Transaction>
		 * lstAccountTransaction= transactionDAO.getAccountTransactions(model) ; trDto=
		 * lstAccountTransaction[0];
		 * 
		 * System.out.println("lstAccountTransaction ========trDto=="+trDto);
		 * System.out.println("lstAccountTransaction =========="); for (Transaction
		 * tmpTransaction:lstAccountTransaction){
		 * System.out.println("dataaa ===tmpAccount======="+tmpTransaction); }
		 * //((Model) model).addAttribute("transaction",trDto); // return the jsp file
		 * name page "transaction-List";
		 */
		return transactions;
	}

	@RequestMapping(value = "/createTransaction", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_XML_VALUE })
	public @ResponseBody Transaction createTransaction(HttpServletRequest request) {
		// @RequestBody TransactionDTO tra
		Transaction transaction = new Transaction();
		int customerId = (request.getParameter("customerId") != null
				? Integer.parseInt(request.getParameter("customerId").trim())
				: 1);
		int accountId = (request.getParameter("accountId") != null
				? Integer.parseInt(request.getParameter("accountId").trim())
				: 1);
		BigDecimal initialCredit = (request.getParameter("initialCredit") != null
				? new BigDecimal(request.getParameter("initialCredit").trim())
				: new BigDecimal(0));
//		int customerId =tra.getAccountId();
		// int accountId =tra.getCustomerId();
		// BigDecimal initialCredit =tra.getInitialCredit();

		System.out.println("custom id DTO" + customerId);
		Map<Integer, Transaction> customerAccountInfos1 = new HashMap<Integer, Transaction>();
		System.out.println("create Transaction====initialCredit==" + initialCredit);
		System.out.println("create Transaction====initialCredit==" + (initialCredit == new BigDecimal(0)));
		if (initialCredit.compareTo(new BigDecimal(0)) == 0) {
			BigDecimal balance = initialCredit.add(new BigDecimal(20000));
			Transaction trans = new Transaction(1, initialCredit, balance, customerId, accountId,
					"No new Transaction ");
			customerAccountInfos1.put(accountId, trans);
			transaction = customerAccountInfos1.get(accountId);
			System.out.println("No new Transactions ");

		} else {
			BigDecimal balance = initialCredit.add(new BigDecimal(20000));
			Transaction trans = new Transaction(1, initialCredit, balance, customerId, accountId,
					"New Transaction succeded");
			customerAccountInfos1.put(accountId, trans);
			transaction = customerAccountInfos1.get(accountId);
			String newTransactionAccount = "The Transaction is transfered to account"
					+ customerAccountInfos1.get(accountId).toString();
			System.out.println("newTransactionAccount");

		}

		return transaction;
	}

	@PostMapping(value = "/createTransactionXML", produces = { MediaType.APPLICATION_XML_VALUE })
	public @ResponseBody Transaction createTransaction(@RequestBody TransactionDTO tra) {

		// @RequestBody TransactionDTO tra
		Transaction transaction = new Transaction();
		// int customerId
		// =(request.getParameter("customerId")!=null?Integer.parseInt(request.getParameter("customerId").trim()):1);
		// int accountId
		// =(request.getParameter("accountId")!=null?Integer.parseInt(request.getParameter("accountId").trim()):1);
		// BigDecimal initialCredit = (request.getParameter("initialCredit")!=null?new
		// BigDecimal(request.getParameter("initialCredit").trim()):new BigDecimal(0));
		int customerId = tra.getAccountId();
		int accountId = tra.getCustomerId();
		BigDecimal initialCredit = tra.getInitialCredit();

		System.out.println("custom id DTO" + customerId);
		System.out.println("custom id DTO accountId" + accountId);
		System.out.println("custom id DTO initialCredit" + initialCredit);
		Map<Integer, Transaction> customerAccountInfos1 = new HashMap<Integer, Transaction>();
		System.out.println("create Transaction====initialCredit==" + initialCredit);
		System.out.println("create Transaction====initialCredit==" + (initialCredit == new BigDecimal(0)));
		if (initialCredit.compareTo(new BigDecimal(0)) == 0) {
			BigDecimal balance = initialCredit.add(new BigDecimal(20000));
			Transaction trans = new Transaction(1, initialCredit, balance, customerId, accountId,
					"No new Transaction ");
			customerAccountInfos1.put(accountId, trans);
			transaction = customerAccountInfos1.get(accountId);
			System.out.println("No new Transactions ");

		} else {
			BigDecimal balance = initialCredit.add(new BigDecimal(20000));
			Transaction trans = new Transaction(1, initialCredit, balance, customerId, accountId,
					"New Transaction succeded");
			customerAccountInfos1.put(accountId, trans);
			transaction = customerAccountInfos1.get(accountId);
			String newTransactionAccount = "The Transaction is transfered to account"
					+ customerAccountInfos1.get(accountId).toString();
			System.out.println("newTransactionAccount");

		}

		return transaction;
	}
}
