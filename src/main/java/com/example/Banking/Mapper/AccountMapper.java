package com.example.Banking.Mapper;

import com.example.Banking.Dto.AccountDto;
import com.example.Banking.Entity.Account;

public class AccountMapper {

    public static AccountDto mapToAccountDto(Account account){
        AccountDto acc = new AccountDto(
                account.getId(),
                account.getAccountHolderName(),
                account.getBalance()
        );
        return acc;
    }

    public static Account mapToAccount(AccountDto accountDto){
        Account acc = new Account(
                accountDto.accountHolderName(),
                accountDto.balance()
        );
        return acc;
    }
}
