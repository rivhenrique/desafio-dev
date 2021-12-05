package br.com.bycoders.avaliacao.cnabpersister.service;

import br.com.bycoders.avaliacao.cnabpersister.enums.TransactionElementsEnum;
import br.com.bycoders.avaliacao.cnabpersister.model.TransactionEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CnabFileService {

    private final TransactionService transactionService;

    public CnabFileService(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    public void processFile(MultipartFile file) {
        List<TransactionEntity> transactionList = new ArrayList<>();
        String[] lineList = fromFileToLineStringArray(file);
        for ( String line : lineList ) {
            transactionList.add(mapLineToTransactionEntity(line));
        }
        transactionService.persistListFromFile(transactionList);
    }

    private TransactionEntity mapLineToTransactionEntity(String line) {
        Map<String, String> transactionElements = new HashMap<>();
        for (TransactionElementsEnum elementEnum : TransactionElementsEnum.values()) {
            lineToMap(line, transactionElements,  elementEnum);
        }
        return transactionService.mapToEntityWithRules(transactionElements);
    }

    private void lineToMap(String line, Map<String, String> mapOfElements, TransactionElementsEnum elementEnum) {
        Integer index = elementEnum.getIndex();
        Integer length = elementEnum.getLength();
        String element = line.substring(index, Math.min(index + length, line.length()));
        mapOfElements.put(elementEnum.getKeyName(), element);
    }

    private String[] fromFileToLineStringArray(MultipartFile file) {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultStringBuilder.toString().split("\n");
    }
}
