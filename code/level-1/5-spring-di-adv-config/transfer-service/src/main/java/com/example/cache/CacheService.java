package com.example.cache;


import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.config.RepoQualifier;
import com.example.model.Account;
import com.example.repository.AccountRepository;

@Component
@Scope("singleton")
@Lazy(value = false)
public class CacheService {

	@Autowired
	@RepoQualifier(tech = "jdbc",db = "mysql")
	private AccountRepository accountRepository;
	
	private Map<String, Account> cache;
	
	public CacheService() {
		System.out.println("CacheService component created");
	}
	
	
	@PostConstruct
	public void init() {
		cache=new HashMap<>();
		//...
		System.out.println("CacheService::init()");
	}
	
	@PreDestroy
	public void cleanUp() {
		System.out.println("CacheService::cleanUp()");
	}
	
	
}
