package com.bank.publicinfo.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table
@JsonSerialize
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor()
public class License {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    @NotNull
    private byte[] photo;
    @OneToOne()
    @JoinColumn(name = "bank_details_id")
    private BankDetails bankDetails;

}
