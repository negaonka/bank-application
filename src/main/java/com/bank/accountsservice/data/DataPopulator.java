package com.bank.accountsservice.data;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bank.accountsservice.model.Accounts;
import com.bank.accountsservice.model.Customer;
import com.bank.accountsservice.repository.AccountsRepository;

@Component
public class DataPopulator {
	
		private final AccountsRepository accountsRepository;

		@Autowired
		public DataPopulator(AccountsRepository accountsRepository) {
			this.accountsRepository = accountsRepository;
		}

		@PostConstruct
		public void insertPropertyData() {
			accountsRepository.save(new Customer("1001", "Alice"), new Accounts("20932K3150XC",100.0));
			accountsRepository.save(new Customer("1002", "Bob"), new Accounts("20832K1450",101.23));
			accountsRepository.save(new Customer("1003", "Mike"), new Accounts("20832K1460",198.00));
			
			
		}
}
