package com.bank.publicinfo.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@JsonSerialize
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor()
public class Certificate {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private byte[] photo;
    @OneToOne()
    @JoinColumn(name = "bank_details_id")
    private BankDetails bankDetails;

}
