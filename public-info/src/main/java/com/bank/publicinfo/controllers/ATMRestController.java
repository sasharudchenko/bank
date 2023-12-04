package com.bank.publicinfo.controllers;

import com.bank.publicinfo.dto.ATMDTO;
import com.bank.publicinfo.mapstruct.ATMMapper;
import com.bank.publicinfo.model.ATM;
import com.bank.publicinfo.service.ATMService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/atm")
@RequiredArgsConstructor
@Tag(name = "Банкомат", description = "Методы для работы с банкоматами")
public class ATMRestController {
    private final ATMService atmService;
    private final ATMMapper atmMapper;

    @PostMapping
    @Operation(summary = "Добавление банкомата")
    public ResponseEntity<HttpStatus> save(@RequestBody @Valid ATMDTO atmdto) {
        ATM atm = atmService.saveATM(atmMapper.ATMDTOToATM(atmdto));
        return new ResponseEntity(atm, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Данные банкомата по ID")
    public ResponseEntity<ATM> getById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(atmService.getATM(id), HttpStatus.OK);
    }
    @GetMapping("/all")
    @Operation(summary = "Данные всех банкоматов")
    public ResponseEntity<List<ATM>> all() {
        return new ResponseEntity<>(atmService.allATM(), HttpStatus.OK);
    }
    @PatchMapping("/update/{id}")
    @Operation(summary = "Обновление данных банкомата")
    public ResponseEntity<HttpStatus> update(@RequestBody @Valid ATMDTO atmdto,
                                             @PathVariable("id") Long id) {
        atmService.updateATM(atmMapper.ATMDTOToATM(atmdto), id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Удаление банкомата по ID")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id) {

        atmService.deleteATM(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }


}