package com.bank.accountsservice.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.bank.accountsservice.model.Accounts;
import com.bank.accountsservice.model.Customer;

@Component
public class AccountsRepositoryImpl implements AccountsRepository {

	private Map<Customer, Accounts> customerAccountsMap = new HashMap<>();

	 
	@Override
	public Optional<Accounts> getOne(String customerID) {
			Accounts accounts = null;
		    for (Customer customer : customerAccountsMap.keySet()) {
		        if (customer.getCustomerId().equals(customerID)) {
		        	accounts = customerAccountsMap.get(customer);
		            break;
		        }
		    }
		    return Optional.ofNullable(accounts);
	}

	@Override
	public Set<Customer> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void save(Customer cust, Accounts account) {
		customerAccountsMap.put(cust, account);
		
	}

}
