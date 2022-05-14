package com.example.service;

import com.example.model.Account;
import com.example.repository.AccountRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("transferService")
public class UPITranferService implements TransferService {

    private static final Logger logger = Logger.getLogger("transfer-service");

    private final AccountRepository accountRepository;

    @Value("${transfer.max.retry}")
    private int transferMaxRetry;

    public UPITranferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void transfer(double amount, String from, String to) {
        logger.info("transfer initiated");
        System.out.println(transferMaxRetry);
        Account fromAccount = accountRepository.loadAccount(from);
        Account toAccount = accountRepository.loadAccount(to);

        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);

        accountRepository.updateAccount(fromAccount);
        accountRepository.updateAccount(toAccount);
        logger.info("transfer completed");
    }
}
