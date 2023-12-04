package com.bank.publicinfo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.util.List;

@Entity
@Table
@JsonSerialize
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor()
public class Branch {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    @NotNull
    private String address;
    @Column(name = "phone_number", unique = true)
    @NotNull
    private long phoneNumber;
    @Column
    @NotNull
    private String city;
    @Column(name = "start_of_work")
    @NotNull
    private Time startOfWork;
    @Column(name = "end_of_work")
    @NotNull
    private Time endOfWork;
    @OneToMany(mappedBy = "branch")
    @JsonIgnore
    private List<ATM> atms;


}
