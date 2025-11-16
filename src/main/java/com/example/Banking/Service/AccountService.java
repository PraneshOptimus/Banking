package com.example.Banking.Service;


import com.example.Banking.Dto.AccountDto;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface AccountService {

   AccountDto addAccount(AccountDto accountDto);

   AccountDto getAccById(Long id);

   AccountDto deposit(Long id,double amount);

   AccountDto withdraw(Long id, double amount);

   List<AccountDto> listAllAcc();

   void deleteById(long id);

}
