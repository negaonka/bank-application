package com.bank.accountsservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Getter @Setter @ToString
@AllArgsConstructor
public class Accounts {
	
    private String accountId;

    private double balance;


}
