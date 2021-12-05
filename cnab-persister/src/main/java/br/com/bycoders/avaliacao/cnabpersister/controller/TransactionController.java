package br.com.bycoders.avaliacao.cnabpersister.controller;

import br.com.bycoders.avaliacao.cnabpersister.dto.StoresTransactionsResponseDTO;
import br.com.bycoders.avaliacao.cnabpersister.model.TransactionEntity;
import br.com.bycoders.avaliacao.cnabpersister.service.CnabFileService;
import br.com.bycoders.avaliacao.cnabpersister.service.TransactionService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping(value = "/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    private final CnabFileService cnabFileService;

    public TransactionController(TransactionService transactionService, CnabFileService cnabFileService) {
        this.transactionService = transactionService;
        this.cnabFileService = cnabFileService;
    }

    @GetMapping("/stores/report")
    public StoresTransactionsResponseDTO generateReportOfStore() {
        return transactionService.detailStoreTransactions();
    }

    @PostMapping(value = "/cnab-file/upload")
    public String cnabFileUpload(@RequestParam("file") MultipartFile file) {
        List<TransactionEntity> transactionEntities = cnabFileService.processFile(file);
        transactionService.persistListFromFile(transactionEntities);
        return "iei, foi";
    }

    //TODO remover
    @GetMapping("/new")
    public TransactionEntity createNewTransaction() {
        return transactionService.createNewEntity();
    }

}
