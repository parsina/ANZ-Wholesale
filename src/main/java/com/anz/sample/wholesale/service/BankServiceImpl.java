package com.anz.sample.wholesale.service;

import com.anz.sample.wholesale.model.Account;
import com.anz.sample.wholesale.model.Transaction;
import com.anz.sample.wholesale.repository.AccountRepository;
import com.anz.sample.wholesale.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankServiceImpl implements BankService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;


    @Override
    public List<Account> findAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public List<Transaction> findAllTransactions(Long accountId) {
        return transactionRepository.findAllByAccountId(accountId);
    }
}
