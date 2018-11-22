package com.owona.core.ecommercecore.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Code implements Serializable {

    @Id
    @GeneratedValue
    private Long codeId;

    private String codeStr;
    private int codeType; // 0:active, 1: reset PW

    //@Column(columnDefinition="DATETIME")
    private Date codeDate;

    @ManyToOne
    @JoinColumn(name = "clientId")
    private Client client;

    public Long getCodeId() {
        return codeId;
    }

    public void setCodeId(Long codeId) {
        this.codeId = codeId;
    }

    public String getCodeStr() {
        return codeStr;
    }

    public void setCodeStr(String codeStr) {
        this.codeStr = codeStr;
    }

    public int getCodeType() {
        return codeType;
    }

    public void setCodeType(int codeType) {
        this.codeType = codeType;
    }

    public Date getCodeDate() {
        return codeDate;
    }

    public void setCodeDate(Date codeDate) {
        this.codeDate = codeDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
