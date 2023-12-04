package com.bank.publicinfo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.transform.Source;
import java.util.Objects;

@Entity
@Table(name = "bank_details")
@JsonSerialize
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor()
public class BankDetails {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    @NotNull
    private long bik;
    @Column (unique = true)
    @NotNull
    private long inn;
    @Column (unique = true)
    @NotNull
    private long kpp;

    @Column(name = "cor_account", unique = true)
    @NotNull()
    private int corAccount;
    @Column
    @Size(max = 180)
    @NotNull()
    private String city;
    @Column(name = "joint_stock_company")
    @Size(max = 15)
    @NotNull()
    private String jointStockCompany;
    @Column
    @Size(max = 80)
    @NotNull()
    private String name;
    @OneToOne(mappedBy = "bankDetails")
    @JsonIgnore
    private License license;
    @OneToOne(mappedBy = "bankDetails")
    @JsonIgnore
    private Certificate certificate;


}
