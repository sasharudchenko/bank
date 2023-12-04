package com.bank.publicinfo.aspect;

import com.bank.publicinfo.model.Audit;
import com.bank.publicinfo.service.AuditService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

@Aspect
@Component
@RequiredArgsConstructor
@Slf4j(topic = "AuditAspect")

public class AuditAspect {


    private static String ROLE_ADMIN = "Admin";

    private final AuditService auditService;
    private final ObjectMapper objectMapper;

    @AfterReturning(pointcut = "execution(* com.bank.publicinfo.controllers.*.save(*))",
            returning = "res")
    public void afterSave(JoinPoint joinPoint, Object res) throws JsonProcessingException {
        log.info("Adding an entry to the audit after executing the save method of another entity");
        Object[] signatureArgs = joinPoint.getArgs();
        String resultJson = objectMapper.writeValueAsString(res);

        Audit audit = createAudit(signatureArgs[0].getClass().getSimpleName(), "Save", ROLE_ADMIN,
                null, LocalDateTime.now(), null, null, resultJson);
        log.info("Adding an entry to the audit after executing the save method of another entity");
        auditService.saveAudit(audit);

    }

    @AfterReturning("execution(* com.bank.publicinfo.controllers.*.update(*, *))")
    public void afterUpdate(JoinPoint joinPoint) throws JsonProcessingException {
        log.info("Adding an entry to the audit after executing the update method of another entity");

        Object[] signatureArgs = joinPoint.getArgs(); // Получаем аргументы метода
        String entityType = signatureArgs[0].getClass().getSimpleName();
        long entityId = 0;
        if (signatureArgs[1] instanceof Long) {
            entityId = ((Long) signatureArgs[1]).byteValue();
        }

        long id = auditService.findIdByJsonId(entityType, entityId);
        Audit idSaveAudit = auditService.getAudit(id);
        Audit audit = createAudit(entityType, "Update", idSaveAudit.getCreatedBy(),
                ROLE_ADMIN, idSaveAudit.getCreatedAt(), LocalDateTime.now(), objectMapper.writeValueAsString(signatureArgs[0]),
                idSaveAudit.getEntityJson());
        auditService.saveAudit(audit);
    }

    @AfterReturning("execution(* com.bank.publicinfo.controllers.*.delete(*)) ")
    public void afterDelete(JoinPoint joinPoint) {
        log.info("Adding an entry to the audit after executing the method of deleting another entity");
        Object[] signatureArgs = joinPoint.getArgs();
        long entityId = 0;
        if (signatureArgs[0] instanceof Long) {
            entityId = ((Long) signatureArgs[0]).byteValue();
        }

        String entityType = auditService.findEntityTypeBySignature(joinPoint.toString());
        long id = auditService.findIdByJsonId(entityType, entityId);
        Audit audit = auditService.getAudit(id);
        Audit newAudit = createAudit(entityType, "Delete", audit.getCreatedBy(),
                ROLE_ADMIN, audit.getCreatedAt(), LocalDateTime.now(), null, audit.getEntityJson());

        auditService.saveAudit(newAudit);
    }

    private Audit createAudit(String entityType, String operationType, String createdBy, String modifiedBy,
                              LocalDateTime createdAt, LocalDateTime modifiedAt, String newEntityJson,
                              String entityJson) {
        Audit audit = new Audit();
        audit.setEntityType(entityType);
        audit.setOperationType(operationType);
        audit.setCreatedBy(createdBy);
        audit.setModifiedBy(modifiedBy);
        audit.setCreatedAt(createdAt);
        audit.setModifiedAt(modifiedAt);
        audit.setNewEntityJson(newEntityJson);
        audit.setEntityJson(entityJson);
        return audit;

    }
}
