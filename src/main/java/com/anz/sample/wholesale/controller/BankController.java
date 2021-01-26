package com.anz.sample.wholesale.controller;

import com.anz.sample.wholesale.model.Account;
import com.anz.sample.wholesale.model.Transaction;
import com.anz.sample.wholesale.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BankController {

    @Autowired
    private BankService bankService;

    @GetMapping("/accounts")
    public List<Account> findAllAccounts() {
        return bankService.findAllAccounts();
    }

    @GetMapping("/transactions/{accountId}")
    public List<Transaction> findAllTransactions(@PathVariable("accountId") Long id) {
        return bankService.findAllTransactions(id);
    }
}
