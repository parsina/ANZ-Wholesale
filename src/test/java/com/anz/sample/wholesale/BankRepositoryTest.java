package com.anz.sample.wholesale;

import com.anz.sample.wholesale.model.Account;
import com.anz.sample.wholesale.model.Transaction;
import com.anz.sample.wholesale.repository.AccountRepository;
import com.anz.sample.wholesale.repository.TransactionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BankRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Test
    public void whenFindAccountByAccountId_thenReturnAccount() {
        // Given
        Account account = new Account();
        account.setId(1L);

        // When
        Account acc = accountRepository.findById(1L).get();

        // Then
        assertThat(acc.getId()).isEqualTo(account.getId());
    }

    @Test
    public void whenFindAllAccounts_thenReturnAllAccounts() {
        // Given
        Account account = new Account();
        account.setId(1L);

        List<Account> accounts = Collections.singletonList(account);

        // When
        List<Account> accountList = accountRepository.findAll();

        // Then
        assertThat(accountList.get(0).getId()).isEqualTo(accounts.get(0).getId());
    }

    @Test
    public void whenFindTransactionsByAccountId_thenReturnListOfTransactions() {
        // Given
        Transaction transaction = new Transaction();
        transaction.setId(1L);

        List<Transaction> transactions = Collections.singletonList(transaction);

        // When
        List<Transaction> transactionList = transactionRepository.findAllByAccountId(1L);

        // Then
        assertThat(transactionList.get(0).getId()).isEqualTo(transactions.get(0).getId());
    }
}
