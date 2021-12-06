package br.com.bycoders.avaliacao.cnabpersister.service;

import br.com.bycoders.avaliacao.cnabpersister.dto.StoreTransactionsAndBalanceDTO;
import br.com.bycoders.avaliacao.cnabpersister.dto.StoresTransactionsResponseDTO;
import br.com.bycoders.avaliacao.cnabpersister.dto.TransactionDTO;
import br.com.bycoders.avaliacao.cnabpersister.dto.query.StoresAndBalancesDTO;
import br.com.bycoders.avaliacao.cnabpersister.model.TransactionEntity;
import br.com.bycoders.avaliacao.cnabpersister.model.TransactionTypeEntity;
import br.com.bycoders.avaliacao.cnabpersister.repository.TransactionRepository;
import br.com.bycoders.avaliacao.cnabpersister.repository.TransactionTypeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    private final TransactionTypeRepository transactionTypeRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository, TransactionTypeRepository transactionTypeRepository) {
        this.transactionRepository = transactionRepository;
        this.transactionTypeRepository = transactionTypeRepository;
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

    public TransactionEntity mapToEntityWithRules(Map<String, String> transactionElements) {
        final ObjectMapper mapper = new ObjectMapper();
        TransactionEntity transactionEntity = mapper.convertValue(transactionElements, TransactionEntity.class);
        transactionEntity.setAmount(transactionEntity.getAmount().divide(new BigDecimal(100)));
        return transactionEntity;
    }

    public void persistListFromFile(List<TransactionEntity> transactionEntities) {
        transactionRepository.saveAll(transactionEntities);
    }

    private List<TransactionDTO> getTransactionListByStoreName(String storeName) {
        List<TransactionDTO> dtoList = new ArrayList<>();
        List<TransactionEntity> entityList = transactionRepository.findTransactionEntityByStoreName(storeName);
        if ( entityList != null && !entityList.isEmpty() ) {
            dtoList = mapFromEntityToDTO(entityList);
        }
        return dtoList;
    }

    private List<TransactionDTO> mapFromEntityToDTO(List<TransactionEntity> entityList) {
        List<TransactionDTO> dtoList = new ArrayList<>();
        List<TransactionTypeEntity> typeList = transactionTypeRepository.findAll();
        for (TransactionEntity entity : entityList) {
            TransactionTypeEntity typeEntity = getTransactionTypeEntity(typeList, entity);
            dtoList.add(new TransactionDTO(entity, typeEntity.getSignal(), typeEntity.getDescription()));
        }
        return dtoList;
    }

    private TransactionTypeEntity getTransactionTypeEntity(List<TransactionTypeEntity> typeList, TransactionEntity entity) {
        return typeList.stream()
                .filter(type -> entity.getTypeId().equals(type.getTransactionTypeId()))
                .findFirst()
                .orElseGet(() -> typeList.get(0));
    }
}
