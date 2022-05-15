package com.example.service;

import com.example.exeception.AccountBalanceException.AccountBalanceException;
import com.example.model.Account;
import com.example.repository.AccountRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional(
            transactionManager = "transactionManager",
            rollbackFor = {RuntimeException.class},
            noRollbackFor = {},
            timeout = -1,
            isolation = Isolation.READ_COMMITTED,
            propagation = Propagation.NESTED
    )
    @Override
    public void transfer(double amount, String from, String to) {
        try {
            Account fromAccount = accountRepository.loadAccount(from);
            Account toAccount = accountRepository.loadAccount(to);
            if (fromAccount.getBalance() < amount) {
                throw new AccountBalanceException("no enough balance");
            }
            fromAccount.setBalance(fromAccount.getBalance() - amount);
            toAccount.setBalance(toAccount.getBalance() + amount);
            accountRepository.updateAccount(fromAccount);
            accountRepository.updateAccount(toAccount);
        } catch (EmptyResultDataAccessException e) {
            System.err.println("account not exist");
        }

    }

}
