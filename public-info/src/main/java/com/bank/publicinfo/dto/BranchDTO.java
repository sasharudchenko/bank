package com.bank.publicinfo.dto;

import com.bank.publicinfo.model.ATM;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.util.List;
@Getter
@Setter
public class BranchDTO {


    private String address;

    private long phoneNumber;

    private String city;

    private Time startOfWork;

    private Time endOfWork;
    private List<ATM> atms;

}
