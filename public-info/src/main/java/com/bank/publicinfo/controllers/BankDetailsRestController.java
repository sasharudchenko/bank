package com.bank.publicinfo.controllers;

import com.bank.publicinfo.dto.BankDetailsDTO;
import com.bank.publicinfo.mapstruct.BankDetailsMapper;
import com.bank.publicinfo.model.BankDetails;
import com.bank.publicinfo.service.BankDetailsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/bankDetails")
@Tag(name = "Данные банка", description = "Методы для работы с данными банка")
@RequiredArgsConstructor
public class BankDetailsRestController {

    private final BankDetailsService bankDetailsService;
    private final BankDetailsMapper bankDetailsMapper;


    @PostMapping()
    @Operation(summary = "Добавление данных")
    public ResponseEntity<HttpStatus> save(@RequestBody @Valid BankDetailsDTO bankDetailsDTO) {

        BankDetails bankDetails = bankDetailsService.saveBankDetails(bankDetailsMapper
                .bankDetailsDTOToBankDetails(bankDetailsDTO));
        return new ResponseEntity(bankDetails, HttpStatus.OK);
    }



    @GetMapping("/{id}")
    @Operation(summary = "Данные банка по ID")
    public ResponseEntity<BankDetails> getById(@PathVariable("id") Long id) {

        return new ResponseEntity<>(bankDetailsService.getBankDetails(id), HttpStatus.OK);
    }
    @PatchMapping("/update/{id}")
    @Operation(summary = "Обновление данных банка по ID")
    public ResponseEntity<HttpStatus> update(@RequestBody @Valid BankDetailsDTO bankDetailsDTO,
            @PathVariable("id") Long id) {
        bankDetailsService.updateBankDetails(bankDetailsMapper
                .bankDetailsDTOToBankDetails(bankDetailsDTO), id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Удаление данных банка по ID")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id) {
        bankDetailsService.deleteBankDetails(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @GetMapping("/all")
    @Operation(summary = "Данные всех банков")
    public ResponseEntity<List<BankDetails>> all() {
        return new ResponseEntity<>(bankDetailsService.allBankDetails(), HttpStatus.OK);
    }


}
