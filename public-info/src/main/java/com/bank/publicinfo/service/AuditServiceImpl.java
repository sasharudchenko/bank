package com.bank.publicinfo.service;

import com.bank.publicinfo.model.ATM;
import com.bank.publicinfo.model.Audit;
import com.bank.publicinfo.repositories.AuditRepository;
import liquibase.pro.packaged.A;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuditServiceImpl implements AuditService {
    private final AuditRepository auditRepository;


    @Override
    @Transactional
    public void saveAudit(Audit audit) {
        auditRepository.save(audit);
    }

    @Override
    public Audit getAudit(long id) {
        return auditRepository.findById(id).get();
    }

//    public long findByEntityType(String entityType, String json) {
//        long id = 0;
//        List<Audit> auditList = allAudit();
//        for (Audit audit : auditList) {
//            if (audit.getEntityJson().length() > 30) {
//                String s = audit.getEntityJson().substring(0, 30);
//                if (audit.getEntityType().equals(entityType) &&
//                        audit.getOperationType().equals("Save") &&
//                        s.equals(json)) {
//                    id = audit.getId();
//                    break;
//
//                }
//            }
//
//        }
//
//        return id;
//    }

    public String findEntityTypeBySignature(String entityType) {
        if (entityType.contains("BankDetails")) {
            return "BankDetailsDTO";
        } else if (entityType.contains("License")) {
            return "LicenseDTO";
        } else if (entityType.contains("Certificate")) {
            return "CertificateDTO";
        } else if (entityType.contains("Branch")) {
            return "BranchDTO";
        } else if (entityType.contains("ATM")) {
            return "ATMDTO";
        } else {
            return "";
        }
    }
    public long findIdByJsonId(String entityType, long id) {
        List<Audit> list = allAudit();
        long auditId = 0;

        for (Audit audit : list) {
            if (audit.getEntityType().contains(entityType) &&
            audit.getEntityJson().contains( "\"id\":" + (id))) {
            auditId = audit.getId();
            break;
            }
        }
        return auditId;

    }

    @Override
    public List<Audit> allAudit() {
        return auditRepository.findAll();
    }

    @Override
    @Transactional
    public void updateAudit(Audit audit, long id) {
        Audit auditBD = auditRepository.findById(id).get();
        auditBD.setEntityType(audit.getEntityType());
        auditBD.setOperationType(audit.getOperationType());
        auditBD.setCreatedBy(audit.getCreatedBy());
        auditBD.setModifiedBy(audit.getModifiedBy());
        auditBD.setCreatedAt(audit.getCreatedAt());
        auditBD.setModifiedAt(audit.getModifiedAt());
        auditBD.setNewEntityJson(audit.getNewEntityJson());
        auditBD.setEntityJson(audit.getEntityJson());
        auditRepository.save(auditBD);
    }

    @Override
    @Transactional
    public void deleteAudit(long id) {
        auditRepository.deleteById(id);
    }
}
