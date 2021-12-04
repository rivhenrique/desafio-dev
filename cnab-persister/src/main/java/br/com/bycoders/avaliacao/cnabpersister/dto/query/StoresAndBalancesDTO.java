package br.com.bycoders.avaliacao.cnabpersister.dto.query;

import java.math.BigDecimal;

public class StoresAndBalancesDTO {

    private String storeName;
    private BigDecimal balance;

    public StoresAndBalancesDTO() {
    }

    public StoresAndBalancesDTO(String storeName, BigDecimal balance) {
        this.storeName = storeName;
        this.balance = balance;
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
}
