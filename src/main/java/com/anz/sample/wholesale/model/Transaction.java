package com.anz.sample.wholesale.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "TRANSACTION_TBL")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long accountId;

    private LocalDate valueDate;
    private Double debitAmount;
    private Double creditAmount;
    private String txnNarrative;
    private String accNumber;
    private String accName;

    @Enumerated(EnumType.ORDINAL)
    private TransactionType txnType;

    @Enumerated(EnumType.ORDINAL)
    private CurrencyType currency;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public LocalDate getValueDate() {
        return valueDate;
    }

    public void setValueDate(LocalDate valueDate) {
        this.valueDate = valueDate;
    }

    public Double getDebitAmount() {
        return debitAmount;
    }

    public void setDebitAmount(Double debitAmount) {
        this.debitAmount = debitAmount;
    }

    public Double getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(Double creditAmount) {
        this.creditAmount = creditAmount;
    }

    public String getTxnNarrative() {
        return txnNarrative;
    }

    public void setTxnNarrative(String txnNarrative) {
        this.txnNarrative = txnNarrative;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public TransactionType getTxnType() {
        return txnType;
    }

    public void setTxnType(TransactionType txnType) {
        this.txnType = txnType;
    }

    public CurrencyType getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyType currency) {
        this.currency = currency;
    }
}
