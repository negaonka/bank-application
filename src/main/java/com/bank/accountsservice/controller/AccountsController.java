package com.bank.accountsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.bank.accountsservice.model.Accounts;
import com.bank.accountsservice.model.Customer;
import com.bank.accountsservice.model.CustomerDetails;
import com.bank.accountsservice.service.AccountService;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;



@RestController
public class AccountsController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/myAccount")
    public Accounts getAccountDetails(@RequestBody String customerID) {

        Accounts accounts = accountService.findByCustomerId(customerID);
        if (accounts != null) {
            return accounts;
        } else {
            return null;
        }
    }


	/*
	 * @PostMapping("/myCustomerDetails")
	 * 
	 * @CircuitBreaker(name = "detailsForCustomerSupportApp",
	 * fallbackMethod="myCustomerDetailsFallBack")
	 * 
	 * @Retry(name = "retryForCustomerDetails", fallbackMethod =
	 * "myCustomerDetailsFallBack") public CustomerDetails
	 * myCustomerDetails(@RequestHeader("bank-correlation-id") String
	 * correlationid, @RequestBody Customer customer) { Accounts accounts =
	 * accountsRepository.findByCustomerId(customer.getCustomerId());
	 * 
	 * CustomerDetails customerDetails = new CustomerDetails();
	 * customerDetails.setAccounts(accounts);
	 * 
	 * return customerDetails; }
	 */
    private CustomerDetails myCustomerDetailsFallBack(@RequestHeader("bank-correlation-id") String correlationid, Customer customer, Throwable t) {
        CustomerDetails customerDetails = new CustomerDetails();
        return customerDetails;
    }


    @GetMapping("/sayHello")
    //@RateLimiter(name = "sayHello", fallbackMethod = "sayHelloFallback")
    public String sayHello() {
        return "Hello, Welcome to Bank Application";
    }

    private String sayHelloFallback(Throwable t) {
        return "Hi, Welcome to Bank Application";
    }
}
