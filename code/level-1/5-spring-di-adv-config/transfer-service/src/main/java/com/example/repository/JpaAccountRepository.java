package com.example.repository;

import com.example.config.RepoQualifier;
import com.example.model.Account;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
//
@Component("jpaAccountRepository")
@RepoQualifier(tech = "jpa",db = "mysql")
public class JpaAccountRepository implements AccountRepository{

    private static final Logger logger=Logger.getLogger("transfer-service");

    public JpaAccountRepository() {
        logger.info("JpaAccountRepository component created");
    }

    @Override
    public Account loadAccount(String number) {
        return null;
    }

    @Override
    public void updateAccount(Account account) {

    }
}
