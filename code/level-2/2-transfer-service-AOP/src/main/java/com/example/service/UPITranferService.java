package com.example.service;

import com.example.model.Account;
import com.example.repository.AccountRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service("transferService")
public class UPITranferService implements TransferService {

    private final AccountRepository accountRepository;

    public UPITranferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @PostConstruct
    public void init() {
    }

    @Override
    public void transfer(double amount, String from, String to) {
        System.out.println(">");
        Account fromAccount = accountRepository.loadAccount(from);
        Account toAccount = accountRepository.loadAccount(to);
        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);
        if (1 == 1)
            throw new RuntimeException("oops");
        accountRepository.updateAccount(fromAccount);
        accountRepository.updateAccount(toAccount);
        System.out.println("<");
    }

}
