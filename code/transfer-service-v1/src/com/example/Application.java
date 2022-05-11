package com.example;

import com.example.repository.AccountRepository;
import com.example.repository.JdbcAccountRepository;
import com.example.repository.JpaAccountRepository;
import com.example.service.TransferService;
import com.example.service.TransferServiceImpl;

public class Application {

	public static void main(String[] args) {
		
		//--------------------------------------
		//init
		//--------------------------------------
		AccountRepository jdbcAccountRepository=new JdbcAccountRepository();
		AccountRepository jpaAccountRepository=new JpaAccountRepository();
		TransferService transferService=new TransferServiceImpl(jpaAccountRepository); // constructor-level-Dependency-Injection
		//--------------------------------------
		// use
		//--------------------------------------
		transferService.transfer(300.00, "1", "2");
		
		//--------------------------------------
		// destroy
		//--------------------------------------
		transferService=null;
		
	}
	
}
