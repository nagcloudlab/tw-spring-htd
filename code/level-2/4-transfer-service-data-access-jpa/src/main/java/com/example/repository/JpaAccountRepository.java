package com.example.repository;

import com.example.model.Account;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Qualifier("jpa")
public class JpaAccountRepository implements AccountRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Account loadAccount(String number) {
        return entityManager.find(Account.class,number);
    }

    @Override
    public void updateAccount(Account account) {
        entityManager.merge(account);
    }
}
