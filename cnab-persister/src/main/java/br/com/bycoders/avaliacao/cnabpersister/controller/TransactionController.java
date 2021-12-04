package br.com.bycoders.avaliacao.cnabpersister.controller;

import br.com.bycoders.avaliacao.cnabpersister.model.TransactionEntity;
import br.com.bycoders.avaliacao.cnabpersister.service.TransactionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/new")
    public TransactionEntity createNewTransaction() {
        return transactionService.createNewEntity();
    }

}
