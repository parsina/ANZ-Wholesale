package com.anz.sample.wholesale;


import com.anz.sample.wholesale.controller.BankController;
import com.anz.sample.wholesale.model.Account;
import com.anz.sample.wholesale.model.Transaction;
import com.anz.sample.wholesale.service.BankService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BankController.class)
public class BankRestControlTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private BankService service;

    @Test
    public void givenAccounts_whenFindAllAccounts_thenReturnJsonArray() throws Exception {

        Account account = new Account();
        account.setId(1L);

        List<Account> accounts = Collections.singletonList(account);

        given(service.findAllAccounts()).willReturn(accounts);

        mvc.perform( MockMvcRequestBuilders
                .get("/api/accounts")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").isNotEmpty());
    }

    @Test
    public void givenTransactions_whenFindAllTransactions_thenReturnJsonArray() throws Exception {

        Transaction transaction = new Transaction();
        transaction.setId(1L);
        List<Transaction> transactions = Collections.singletonList(transaction);
        given(service.findAllTransactions(1L)).willReturn(transactions);

        mvc.perform( get("/api/transactions/{accountId}", 1L)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").isNotEmpty());
    }
}
