package br.com.bycoders.avaliacao.cnabpersister.repository;

import br.com.bycoders.avaliacao.cnabpersister.dto.query.StoresAndBalancesDTO;
import br.com.bycoders.avaliacao.cnabpersister.model.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {

    @Query(value =  " select new br.com.bycoders.avaliacao.cnabpersister.dto.query.StoresAndBalancesDTO(t.storeName, sum(t.amount*tt.signal)) " +
                    "   from TransactionEntity t, TransactionTypeEntity tt " +
                    "  where t.typeId = tt.transactionTypeId " +
                    " group by t.storeName ")
    List<StoresAndBalancesDTO> storeBalanceByName();

    List<TransactionEntity> findTransactionEntityByStoreName(String storeName);
}
