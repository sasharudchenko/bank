package com.bank.publicinfo.mapstruct;

import com.bank.publicinfo.dto.BranchDTO;
import com.bank.publicinfo.model.ATM;
import com.bank.publicinfo.model.Branch;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-03T01:37:58+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class BranchMapperImpl implements BranchMapper {

    @Override
    public Branch branchDTOToBranch(BranchDTO branchDTO) {
        if ( branchDTO == null ) {
            return null;
        }

        Branch branch = new Branch();

        branch.setAddress( branchDTO.getAddress() );
        branch.setPhoneNumber( branchDTO.getPhoneNumber() );
        branch.setCity( branchDTO.getCity() );
        branch.setStartOfWork( branchDTO.getStartOfWork() );
        branch.setEndOfWork( branchDTO.getEndOfWork() );
        List<ATM> list = branchDTO.getAtms();
        if ( list != null ) {
            branch.setAtms( new ArrayList<ATM>( list ) );
        }

        return branch;
    }
}
