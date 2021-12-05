package br.com.bycoders.avaliacao.cnabpersister.enums;

public enum TransactionElementsEnum {

    TYPE(0, 1, "typeId"),
    DATE(1, 8, "date"),
    AMOUNT(9, 10, "amount"),
    DOCUMENT(19, 11, "document"),
    CARD_NUMBER(30, 12, "cardNumber"),
    TIME(42, 6, "time"),
    STORE_OWNER_NAME(48, 14, "storeOwnerName"),
    STORE_NAME(62, 19, "storeName");

    TransactionElementsEnum(Integer startIndex, Integer length, String keyName) {
        this.index = startIndex;
        this.length = length;
        this.keyName = keyName;
    }

    private Integer index;
    private Integer length;
    private String keyName;

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }
}
