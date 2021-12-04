package br.com.bycoders.avaliacao.cnabpersister.dto;

import java.util.ArrayList;
import java.util.List;

public class StoresTransactionsResponseDTO {

    private List<StoreTransactionsAndBalanceDTO> storesDetails;

    public StoresTransactionsResponseDTO() {
        storesDetails = new ArrayList<>();
    }

    public List<StoreTransactionsAndBalanceDTO> getStoresDetails() {
        return storesDetails;
    }

    public void setStoresDetails(List<StoreTransactionsAndBalanceDTO> storesDetails) {
        this.storesDetails = storesDetails;
    }
}
