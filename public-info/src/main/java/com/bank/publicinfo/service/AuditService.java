package com.bank.publicinfo.service;

import com.bank.publicinfo.model.ATM;
import com.bank.publicinfo.model.Audit;

import java.util.List;

public interface AuditService {
    void saveAudit(Audit audit);
    Audit getAudit(long id);
    List<Audit> allAudit();
    void updateAudit(Audit audit, long id);
    void deleteAudit(long id);
//    long findByEntityType(String entityType, String json);
    String findEntityTypeBySignature(String entityType);
    public long findIdByJsonId(String entityType, long id);

}
