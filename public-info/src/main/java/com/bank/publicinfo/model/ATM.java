package com.bank.publicinfo.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.micrometer.core.lang.Nullable;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.sql.Time;

@Entity
@Table
@JsonSerialize
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor()
public class ATM {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    @NotNull
    private String address;
    @Column(name = "start_of_work")

    private Time startOfWork;
    @Column(name = "end_of_work")
    private Time endOfWork;
    @Column(name = "all_hours")
    @NotNull
    private boolean allHours;
    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;

//TODO ddfsf
}
