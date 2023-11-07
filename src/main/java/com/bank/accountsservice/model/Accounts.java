package com.bank.accountsservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Getter @Setter @ToString
@AllArgsConstructor
public class Accounts {
	
    private String accountId;

    private double balance;


}
