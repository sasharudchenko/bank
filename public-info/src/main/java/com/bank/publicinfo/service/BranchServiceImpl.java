package com.bank.publicinfo.service;

import com.bank.publicinfo.exception.BranchNotFoundException;
import com.bank.publicinfo.model.Branch;
import com.bank.publicinfo.repositories.BranchRepository;
import com.bank.publicinfo.validator.ValidationBranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@RequiredArgsConstructor
public class BranchServiceImpl implements BranchService {

   private final BranchRepository branchRepository;
   private final ValidationBranchService validationBranchService;

    @Override
    @Transactional
    public Branch saveBranch(Branch branch) {
        Branch branch1 = new Branch();
        if (validationBranchService.isValidBranch(branch)) {
            branch1 = branchRepository.save(branch);
        } else {
            validationBranchService.isValidBranch(branch);
        }
            return branch1;
    }

    @Override
    public Branch getBranch(long id) {
        return branchRepository.findById(id).orElseThrow(() ->
                new BranchNotFoundException("Branch с ID " + id + " не существует"));
    }

    @Override

    public List<Branch> allBranch() {
        return branchRepository.findAll();
    }

    @Override
    @Transactional
    public void updateBranch(Branch branch, long id) {
        Branch branchBD = branchRepository.findById(id).orElseThrow(() ->
                new BranchNotFoundException("Branch с ID " + id + " не существует"));
        branchBD.setAddress(branch.getAddress());
        if (branch.getPhoneNumber() != branchBD.getPhoneNumber()) {
            branchBD.setPhoneNumber(branch.getPhoneNumber());
        }

        branchBD.setCity(branch.getCity());
        branchBD.setStartOfWork(branch.getStartOfWork());
        branchBD.setEndOfWork(branch.getEndOfWork());
        if (validationBranchService.isValidBranch(branch)) {
            branchRepository.save(branchBD);
        } else {
            validationBranchService.isValidBranch(branch);
        }
    }

    @Override
    @Transactional
    public void deleteBranch(long id) {
        if (branchRepository.findById(id).isPresent()) {
            branchRepository.deleteById(id);
        } else {
            throw new BranchNotFoundException("Branch с ID " + id + " не существует");
        }

    }
}
