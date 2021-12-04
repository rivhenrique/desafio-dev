package br.com.bycoders.avaliacao.cnabpersister.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transaction")
public class TransactionEntity {

    @Id
    @Column(name = "transaction_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    @Column(name = "type_id")
    private Long typeId;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "date_time")
    private LocalDateTime dateTime;

    @Column(name = "document")
    private String document;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "store_owner_name")
    private String storeOwnerName;

    @Column(name = "store_name")
    private String storeName;

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long type_id) {
        this.typeId = type_id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getStoreOwnerName() {
        return storeOwnerName;
    }

    public void setStoreOwnerName(String storeOwnerName) {
        this.storeOwnerName = storeOwnerName;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", type_id=" + typeId +
                ", amount=" + amount +
                ", dateTime=" + dateTime +
                ", document='" + document + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", storeOwnerName='" + storeOwnerName + '\'' +
                ", storeName='" + storeName + '\'' +
                '}';
    }
}
