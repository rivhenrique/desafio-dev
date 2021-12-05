package br.com.bycoders.avaliacao.cnabpersister.repository;

import br.com.bycoders.avaliacao.cnabpersister.model.TransactionTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionTypeRepository extends JpaRepository<TransactionTypeEntity, Long> {

}
