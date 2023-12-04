package com.bank.publicinfo.dto;

import com.bank.publicinfo.model.Certificate;
import com.bank.publicinfo.model.License;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
public class BankDetailsDTO {

    private long bik;

    private long inn;

    private long kpp;

    private int corAccount;

    private String city;
    private String jointStockCompany;

    private String name;
    private License license;

    private Certificate certificate;
}
