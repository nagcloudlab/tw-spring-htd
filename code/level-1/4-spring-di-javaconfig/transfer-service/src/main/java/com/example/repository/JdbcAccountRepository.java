package com.example.repository;

import com.example.model.Account;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

//@Component("jdbcAccountRepository")
public class JdbcAccountRepository implements AccountRepository{

    private static final Logger logger=Logger.getLogger("transfer-service");

    private final DataSource dataSource;

//    @Autowired
    public JdbcAccountRepository(DataSource dataSource) {
        this.dataSource = dataSource;
        logger.info("jdbcAccountRepository component created.");
    }

    @Override
    public Account loadAccount(String number) {
        logger.info("loading account - "+number);
        try {
            Connection conn =dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new Account(number,1000.00);
    }

    @Override
    public void updateAccount(Account account) {
        logger.info("updating account - "+account.getNumber());
    }
}
