package com.example.Banking.Dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountDto {

    private long id;
    private String accountHolderName;
    private double balance;

    public AccountDto(String accountHolderName, double balance){
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

}
