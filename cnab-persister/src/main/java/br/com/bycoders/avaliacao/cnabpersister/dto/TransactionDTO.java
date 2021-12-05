package br.com.bycoders.avaliacao.cnabpersister.dto;

import br.com.bycoders.avaliacao.cnabpersister.model.TransactionEntity;
import br.com.bycoders.avaliacao.cnabpersister.util.DateUtil;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionDTO {

    private BigDecimal amount;
    private String description;
    private LocalDateTime transactionDateTime;
    private String receiverDocument;

    public TransactionDTO() {
    }

    public TransactionDTO(TransactionEntity entity, BigDecimal signal, String description) {
        this.amount = entity.getAmount().multiply(signal);
        this.transactionDateTime = DateUtil.stringToDate(entity.getDate(), entity.getTime());
        this.receiverDocument = entity.getDocument();
        this.description = description;
    }


    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getTransactionDateTime() {
        return transactionDateTime;
    }

    public void setTransactionDateTime(LocalDateTime transactionDateTime) {
        this.transactionDateTime = transactionDateTime;
    }

    public String getReceiverDocument() {
        return receiverDocument;
    }

    public void setReceiverDocument(String receiverDocument) {
        this.receiverDocument = receiverDocument;
    }
}
