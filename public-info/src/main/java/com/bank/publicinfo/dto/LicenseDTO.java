package com.bank.publicinfo.dto;

import com.bank.publicinfo.model.BankDetails;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
public class LicenseDTO {
    private byte[] photo;
    private BankDetails bankDetails;

}
