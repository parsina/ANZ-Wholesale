package com.anz.sample.wholesale.service;

import com.anz.sample.wholesale.model.Account;
import com.anz.sample.wholesale.model.Transaction;

import java.util.List;

public interface BankService {

    List<Account> findAllAccounts();

    List<Transaction> findAllTransactions(Long accountId);

}
