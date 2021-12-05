package br.com.bycoders.avaliacao.cnabpersister.dto;

import br.com.bycoders.avaliacao.cnabpersister.model.TransactionEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionDTO {

    private BigDecimal amount;
    private LocalDateTime transactionDateTime;
    private String receiverDocument;

    public TransactionDTO() {
    }

    public TransactionDTO(TransactionEntity entity) {
        this.amount = entity.getAmount();
        //FIXME
        // this.transactionDateTime = entity.getDateTime();
        this.receiverDocument = entity.getDocument();
    }


    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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
