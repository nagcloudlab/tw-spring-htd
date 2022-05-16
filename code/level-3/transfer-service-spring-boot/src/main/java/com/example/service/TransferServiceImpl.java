package com.example.service;

import com.example.entity.Account;
import com.example.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransferServiceImpl implements TransferService {

    private AccountRepository accountRepository;

    public TransferServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional(
            transactionManager = "transactionManager",
            rollbackFor = {},
            noRollbackFor = {},
            isolation = Isolation.READ_COMMITTED,
            propagation = Propagation.REQUIRED
    )
    @Override
    public void transfer(double amount, String source, String destination) {

        Account sourceAccount = accountRepository.load(source);
        Account destinationAccount = accountRepository.load(destination);
        if(sourceAccount.getBalance()<amount)
            throw new AccountBalanceException(sourceAccount.getBalance());
        sourceAccount.setBalance(sourceAccount.getBalance() - amount);
        destinationAccount.setBalance(destinationAccount.getBalance() + amount);

        accountRepository.update(sourceAccount);
        accountRepository.update(destinationAccount);

    }
}
