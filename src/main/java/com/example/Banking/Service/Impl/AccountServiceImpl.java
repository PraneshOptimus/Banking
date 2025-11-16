package com.example.Banking.Service.Impl;


import com.example.Banking.Dto.AccountDto;
import com.example.Banking.Entity.Account;
import com.example.Banking.Exceptions.InsufficientAmountException;
import com.example.Banking.Exceptions.UserNotFoundException;
import com.example.Banking.Mapper.AccountMapper;
import com.example.Banking.Repository.AccountRepository;
import com.example.Banking.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;


    @Override
    public AccountDto addAccount(AccountDto accountDto) {
        Account acc = AccountMapper.mapToAccount(accountDto);
        Account newAcc = accountRepository.save(acc);
        return AccountMapper.mapToAccountDto(newAcc);
    }

    @Override
    public AccountDto getAccById(Long id) {
        Account acc = accountRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User with this id not found"));
        return AccountMapper.mapToAccountDto(acc);
    }

    @Override
    public AccountDto deposit(Long id, double amount) {
        Account acc = accountRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        double tot = acc.getBalance() + amount;
        acc.setBalance(tot);
        Account savedAcc  = accountRepository.save(acc);
        return AccountMapper.mapToAccountDto(savedAcc);
    }

    @Override
    public AccountDto withdraw(Long id, double amount) {
        Account acc = accountRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User Not Found"));
        double Existing_amount = acc.getBalance();
        if(amount > Existing_amount){
            throw new InsufficientAmountException("Insufficient Balance ");
        }
        double new_Amount = Existing_amount - amount;
        acc.setBalance(new_Amount);
        Account savedAcc = accountRepository.save(acc);
        return AccountMapper.mapToAccountDto(savedAcc);
    }

    @Override
    public List<AccountDto> listAllAcc() {
        List<Account> acount = accountRepository.findAll();
        return acount.stream().map(account -> AccountMapper.mapToAccountDto(account))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(long id) {

        Account acc = accountRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not Found"));

        accountRepository.deleteById(id);

    }
}
