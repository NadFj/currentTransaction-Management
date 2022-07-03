package com.currentTransaction.trm.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class TransactionInitialiserServlet extends AbstractAnnotationConfigDispatcherServletInitializer{

	public TransactionInitialiserServlet() {
		
	}
	@Override
	protected Class<?>[] getRootConfigClasses() {
		
		// TODO Auto-generated method stub
		return  new Class []{TransactionsApConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stu
		
		Class[] configFiles = {};
		
		return configFiles;
	}

	@Override
	protected String[] getServletMappings() {
	//	String [] mappings = {"/showTransactions","/createTransaction"};
		String [] mappings = {"/entry/*"};
		// /
		return mappings;
	}

}
