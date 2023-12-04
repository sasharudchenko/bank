package com.bank.publicinfo.controllers;

import com.bank.publicinfo.dto.BranchDTO;
import com.bank.publicinfo.mapstruct.BranchMapper;
import com.bank.publicinfo.model.Branch;
import com.bank.publicinfo.service.BranchService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/branch")
@Tag(name = "Отделения банка", description = "методы для работы с отделениями банка")
@RequiredArgsConstructor
public class BranchRestController {
    private final BranchService branchService;
    private final BranchMapper branchMapper;

    @PostMapping
    @Operation(summary = "Добавление данных")
    public ResponseEntity<HttpStatus> save(@RequestBody @Valid BranchDTO dto) {
        Branch branch = branchService.saveBranch(branchMapper.branchDTOToBranch(dto));
        return new ResponseEntity(branch, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Информация о отделении банка по ID")
    public ResponseEntity<Branch> getById(@PathVariable("id") Long id) {

        return new ResponseEntity<>(branchService.getBranch(id), HttpStatus.OK);
    }
    @GetMapping("/all")
    @Operation(summary = "Информация о всех отделениях банка ")
    public ResponseEntity<List<Branch>> all() {

        return new ResponseEntity<>(branchService.allBranch(), HttpStatus.OK);
    }
    @PatchMapping("/update/{id}")
    @Operation(summary = "Обновление данных")
    public ResponseEntity<HttpStatus> update(@RequestBody @Valid BranchDTO dto,
                                             @PathVariable("id") Long id) {
        branchService.updateBranch(branchMapper.branchDTOToBranch(dto), id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Удаление данных")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id) {
        branchService.deleteBranch(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }



}
