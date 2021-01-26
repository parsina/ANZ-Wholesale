package com.anz.sample.wholesale;

import com.anz.sample.wholesale.model.Account;
import com.anz.sample.wholesale.model.Transaction;
import com.anz.sample.wholesale.repository.AccountRepository;
import com.anz.sample.wholesale.repository.TransactionRepository;
import com.anz.sample.wholesale.service.BankService;
import com.anz.sample.wholesale.service.BankServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class BankServiceImplTest {
    @TestConfiguration
    static class BankServiceImplIntegrationTestContextConfiguration {
        @Bean
        public BankService bankService() {
            return new BankServiceImpl();
        }
    }

    @Autowired
    private BankService bankService;

    @MockBean
    private AccountRepository accountRepository;

    @MockBean
    private TransactionRepository transactionRepository;

    @Before
    public void setUp() {
        Account account = new Account();
        account.setId(1L);
        Mockito.when(accountRepository.findAll()).thenReturn(List.of(account));

        Transaction transaction = new Transaction();
        transaction.setId(1L);
        Mockito.when(transactionRepository.findAllByAccountId(1L)).thenReturn(List.of(transaction));
    }

    @Test
    public void whenFindAllAccounts_thenAccountsShouldBeFound() {
        List<Account> accountList = bankService.findAllAccounts();
        assertThat(accountList.get(0).getId()).isEqualTo(1L);
    }

    @Test
    public void whenPassAccountId_thenTransactionsShouldBeFound() {
        List<Transaction> transactionList = bankService.findAllTransactions(1L);
        assertThat(transactionList.get(0).getId()).isEqualTo(1L);
    }
}
