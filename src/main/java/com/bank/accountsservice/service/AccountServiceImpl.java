package com.bank.accountsservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.accountsservice.model.Accounts;
import com.bank.accountsservice.repository.AccountsRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountsRepository accountRepo;

	@Override
	public Accounts findByCustomerId(String customerId) {
		
		Optional<Accounts> accounts =  accountRepo.getOne(customerId);
		if(accounts.isPresent()) {
			return accounts.get();
		}
		return null;
	}

}
