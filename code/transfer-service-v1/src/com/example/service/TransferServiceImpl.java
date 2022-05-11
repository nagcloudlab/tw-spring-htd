package com.example.service;

import org.apache.log4j.Logger;

import com.example.model.Account;
import com.example.repository.AccountRepository;

// dependent
public class TransferServiceImpl implements TransferService {

	private AccountRepository accountRepository;

	private static Logger logger = Logger.getLogger("transfer-service");

	public TransferServiceImpl(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
		logger.info("transferService component instantiated");
	}

	public void transfer(double amount, String source, String target) {

		logger.info("transfer intiated");

		Account sourceAccount = accountRepository.loadAccount(source);
		Account targetAccount = accountRepository.loadAccount(target);
		// ..
		sourceAccount.setBalance(sourceAccount.getBalance() - amount);
		targetAccount.setBalance(targetAccount.getBalance() + amount);
		// ..
		accountRepository.updateAccount(sourceAccount);
		accountRepository.updateAccount(targetAccount);
		logger.info("transfer finished");
	}

}
