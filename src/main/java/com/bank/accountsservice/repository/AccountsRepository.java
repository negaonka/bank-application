package com.bank.accountsservice.repository;

import java.util.Optional;
import java.util.Set;


import com.bank.accountsservice.model.Accounts;
import com.bank.accountsservice.model.Customer;


public interface AccountsRepository {

	Optional<Accounts> getOne(String customerID);

	Set<Customer> getAll();

	void clear();
	
	void save(Customer cust, Accounts accounts);


}
