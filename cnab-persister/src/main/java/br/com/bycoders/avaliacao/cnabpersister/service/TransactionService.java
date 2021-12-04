package br.com.bycoders.avaliacao.cnabpersister.service;

import br.com.bycoders.avaliacao.cnabpersister.dto.StoreTransactionsAndBalanceDTO;
import br.com.bycoders.avaliacao.cnabpersister.dto.StoresTransactionsResponseDTO;
import br.com.bycoders.avaliacao.cnabpersister.dto.TransactionDTO;
import br.com.bycoders.avaliacao.cnabpersister.dto.query.StoresAndBalancesDTO;
import br.com.bycoders.avaliacao.cnabpersister.model.TransactionEntity;
import br.com.bycoders.avaliacao.cnabpersister.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    //TODO remover esse método
    public TransactionEntity createNewEntity() {
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setAmount(BigDecimal.ONE);
        transactionEntity.setCardNumber("1234");
        transactionEntity.setDocument("12345678912");
        transactionEntity.setStoreName("Teste né 2");
        transactionEntity.setStoreOwnerName("Eu");
        transactionEntity.setDateTime(LocalDateTime.now());
        transactionEntity.setTypeId(1L);
        return transactionRepository.save(transactionEntity);
    }

    public StoresTransactionsResponseDTO detailStoreTransactions() {
        StoresTransactionsResponseDTO responseDTO = new StoresTransactionsResponseDTO();

        List<StoresAndBalancesDTO> storesAndBalancesDTOS = transactionRepository.storeBalanceByName();

        storesAndBalancesDTOS.forEach(dto -> {
            List<TransactionDTO> transactionsByStore = getTransactionListByStoreName(dto.getStoreName());
            responseDTO.getStoresDetails()
                    .add(new StoreTransactionsAndBalanceDTO(dto.getStoreName(), dto.getBalance(), transactionsByStore));
        });
        return responseDTO;
    }

    private List<TransactionDTO> getTransactionListByStoreName(String storeName) {
        List<TransactionDTO> dtoList = new ArrayList<>();
        List<TransactionEntity> entityList = transactionRepository.findTransactionEntityByStoreName(storeName);
        if ( entityList != null && !entityList.isEmpty() ) {
            dtoList = entityList.stream()
                    .map(TransactionDTO::new)
                    .collect(Collectors.toList());
        }
        return dtoList;
    }

}
