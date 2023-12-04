package com.bank.publicinfo.mapstruct;

import com.bank.publicinfo.dto.BranchDTO;
import com.bank.publicinfo.model.Branch;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface BranchMapper {
    Branch branchDTOToBranch(BranchDTO branchDTO);
}
