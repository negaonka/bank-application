package com.bank.accountsservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Getter @Setter @ToString
@AllArgsConstructor
public class Customer {

    private String customerId;

    private String name;


}
