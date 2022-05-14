package com.example.repository;

import com.example.model.Account;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcAccountRepository implements AccountRepository {

    private static final Logger logger = Logger.getLogger("transfer-service");

    @Override
    public Account loadAccount(String number) {
        logger.info("loading account-" + number);
        return new Account(number, 1000.00);
    }

    @Override
    public void updateAccount(Account account) {
        logger.info("updating account-" + account.getNumber());
    }
}
