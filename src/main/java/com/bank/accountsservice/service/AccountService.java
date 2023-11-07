package com.bank.accountsservice.service;

import org.springframework.stereotype.Service;

import com.bank.accountsservice.model.Accounts;

@Service
public interface AccountService {

	Accounts findByCustomerId(String customerId);
}
