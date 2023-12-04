package com.bank.publicinfo.service;

import com.bank.publicinfo.model.Branch;
import com.bank.publicinfo.model.License;

import java.util.List;

public interface BranchService {
    Branch saveBranch(Branch branch);
    Branch getBranch(long id);
    List<Branch> allBranch();
    void updateBranch(Branch branch, long id);
    void deleteBranch(long id);
}
