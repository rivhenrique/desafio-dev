package br.com.bycoders.avaliacao.cnabpersister.repository;

import br.com.bycoders.avaliacao.cnabpersister.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
