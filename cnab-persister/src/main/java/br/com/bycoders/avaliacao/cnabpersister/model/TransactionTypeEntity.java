package br.com.bycoders.avaliacao.cnabpersister.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "transaction_type")
public class TransactionTypeEntity {

    @Id
    @Column(name = "transaction_type_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionTypeId;

    @Column(name = "description")
    private String description;

    @Column(name = "nature")
    private String nature;

    @Column(name = "signal")
    private BigDecimal signal;

    public Long getTransactionTypeId() {
        return transactionTypeId;
    }

    public void setTransactionTypeId(Long transactionTypeId) {
        this.transactionTypeId = transactionTypeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public BigDecimal getSignal() {
        return signal;
    }

    public void setSignal(BigDecimal signal) {
        this.signal = signal;
    }

    @Override
    public String toString() {
        return "TransactionType{" +
                "transactionTypeId=" + transactionTypeId +
                ", description='" + description + '\'' +
                ", nature='" + nature + '\'' +
                ", signal=" + signal +
                '}';
    }
}
