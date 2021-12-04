package br.com.bycoders.avaliacao.cnabpersister.dto;

import java.math.BigDecimal;
import java.util.List;

public class StoreTransactionsAndBalanceDTO {

    private String storeName;
    private BigDecimal balance;
    private List<TransactionDTO> transactionList;

    public StoreTransactionsAndBalanceDTO() {
    }

    public StoreTransactionsAndBalanceDTO(String storeName, BigDecimal balance, List<TransactionDTO> transactionList) {
        this.storeName = storeName;
        this.balance = balance;
        this.transactionList = transactionList;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public List<TransactionDTO> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<TransactionDTO> transactionList) {
        this.transactionList = transactionList;
    }
}
