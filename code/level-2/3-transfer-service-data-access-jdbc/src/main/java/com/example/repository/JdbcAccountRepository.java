package com.example.repository;

import com.example.model.Account;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class JdbcAccountRepository implements AccountRepository {

    private static final Logger logger = Logger.getLogger("transfer-service");
    private JdbcTemplate jdbcTemplate;

    public JdbcAccountRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Account loadAccount(String number) {
        String sql = "select * from accounts where number=?";
        return jdbcTemplate.queryForObject(sql, (rs, index) -> {
            return new Account(rs.getString(1), rs.getDouble(2));
        }, number);
    }

    @Override
    public void updateAccount(Account account) {
        String sql = "update accounts set balance=? where number=?";
        jdbcTemplate.update(sql, account.getBalance(), account.getNumber());
    }
}
