package com.anz.sample.wholesale.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "ACCOUNT_TBL")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    private AccountType accType;

    @Enumerated(EnumType.ORDINAL)
    private CurrencyType currency;

    private Long accNumber;
    private String accName;
    private LocalDate balanceDate;
    private Double balance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AccountType getAccType() {
        return accType;
    }

    public void setAccType(AccountType accType) {
        this.accType = accType;
    }

    public CurrencyType getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyType currency) {
        this.currency = currency;
    }

    public Long getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(Long accNumber) {
        this.accNumber = accNumber;
    }

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public LocalDate getBalanceDate() {
        return balanceDate;
    }

    public void setBalanceDate(LocalDate balanceDate) {
        this.balanceDate = balanceDate;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
