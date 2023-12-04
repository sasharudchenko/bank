package com.bank.publicinfo.dto;

import com.bank.publicinfo.model.Branch;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
@Getter
@Setter
public class ATMDTO {

    private String address;

    private Time startOfWork;

    private Time endOfWork;

    private boolean allHours;
    private Branch branch;



}
