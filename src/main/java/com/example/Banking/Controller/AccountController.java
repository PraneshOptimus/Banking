package com.example.Banking.Controller;


import com.example.Banking.Dto.AccountDto;
import com.example.Banking.Entity.Account;
import com.example.Banking.Service.AccountService;
import com.example.Banking.Service.Impl.AccountServiceImpl;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/acc")
public class AccountController {

    @Autowired
    AccountServiceImpl accountService;

    @PostMapping
    public ResponseEntity<AccountDto> addAcc(@RequestBody AccountDto accountDto){
        return new ResponseEntity<>(accountService.addAccount(accountDto) , HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public AccountDto getById(@PathVariable long id){
        return accountService.getAccById(id);
    }

    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable long id, @RequestBody Map<String, Double> request){
        double amount = request.get("amount");
        return new ResponseEntity<>(accountService.deposit(id, amount), HttpStatus.OK);
    }

    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdraw(@PathVariable long id, @RequestBody Map<String, Double> request){
        double amount = request.get("amount");
        return new ResponseEntity<>(accountService.withdraw(id,amount), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AccountDto>> listAllAcc(){
        return new ResponseEntity<>(accountService.listAllAcc(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id){
        accountService.deleteById(id);
    }
}
