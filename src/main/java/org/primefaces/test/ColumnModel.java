package org.primefaces.test;

public class ColumnModel {
    private Long keyId;
    private String name;

    public ColumnModel(Long keyId, String name) {
        this.keyId = keyId;
        this.name = name;
    }

    public Long getKeyId() {
        return keyId;
    }

    public void setKeyId(Long keyId) {
        this.keyId = keyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
