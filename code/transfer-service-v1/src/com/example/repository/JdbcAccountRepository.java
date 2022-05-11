package com.example.repository;

import org.apache.log4j.Logger;

import com.example.model.Account;

// dependency
public class JdbcAccountRepository implements AccountRepository {
	
	private static Logger logger=Logger.getLogger("transfer-service");
	
	public JdbcAccountRepository() {
		logger.info("jdbcAccountRepository component instantiated");
	}
	
	public Account loadAccount(String number) {
		logger.info("loading account-"+number);
		//...
		return new Account(number, 1000.00);
	}
	
	public void updateAccount(Account account) {
		logger.info("updating account-"+account.getNumber());
		//...
		
	}

}
