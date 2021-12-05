package br.com.bycoders.avaliacao.cnabpersister.controller;

import br.com.bycoders.avaliacao.cnabpersister.dto.StoresTransactionsResponseDTO;
import br.com.bycoders.avaliacao.cnabpersister.service.CnabFileService;
import br.com.bycoders.avaliacao.cnabpersister.service.TransactionService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    public String cnabFileUpload(@RequestParam("file") MultipartFile file, Model model) {
        cnabFileService.processFile(file);
        return "Upload e processamento do arquivo realizado com sucesso! Para ver a lista completa clique no link: \n" +
                "<a href=\"http://localhost:8080/cnab-persister/transaction/stores/report\">Listar Transações</a>\n";
    }

}
