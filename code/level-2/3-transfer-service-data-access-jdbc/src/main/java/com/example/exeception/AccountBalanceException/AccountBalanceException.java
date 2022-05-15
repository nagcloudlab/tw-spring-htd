package com.example.exeception.AccountBalanceException;

public class AccountBalanceException extends RuntimeException {
    public AccountBalanceException(String no_enough_balance) {
        super(no_enough_balance);
    }
}
