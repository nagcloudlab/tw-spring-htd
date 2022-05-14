package com.example.service;

import com.example.model.Account;
import com.example.repository.AccountRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component("transferService")
public class TransferServiceImpl implements TransferService{

    private static final Logger logger=Logger.getLogger("transfer-service");

    private final AccountRepository accountRepository;

//    @Autowired
    public TransferServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
        logger.info("accountRepository injected to transferService");
        logger.info("transferService component created.");
    }

    @Override
    public void transfer(double amount, String source, String target) {

        logger.info("transfer initiated..");

        Account sourceAccount=accountRepository.loadAccount(source);
        Account targetAccount=accountRepository.loadAccount(target);

        sourceAccount.setBalance(sourceAccount.getBalance() - amount);
        targetAccount.setBalance(targetAccount.getBalance()+amount);

        accountRepository.updateAccount(sourceAccount);
        accountRepository.updateAccount(targetAccount);

        logger.info("transfer finished");

    }
}
