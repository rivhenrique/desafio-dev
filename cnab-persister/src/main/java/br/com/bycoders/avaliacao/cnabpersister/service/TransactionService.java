package br.com.bycoders.avaliacao.cnabpersister.service;

import br.com.bycoders.avaliacao.cnabpersister.model.TransactionEntity;
import br.com.bycoders.avaliacao.cnabpersister.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public TransactionEntity createNewEntity() {
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setAmount(BigDecimal.ONE);
        transactionEntity.setCardNumber("1234");
        transactionEntity.setDocument("12345678912");
        transactionEntity.setStoreName("Teste né");
        transactionEntity.setStoreOwnerName("Eu");
        transactionEntity.setTypeId(1L);
        return transactionRepository.save(transactionEntity);
    }
}
