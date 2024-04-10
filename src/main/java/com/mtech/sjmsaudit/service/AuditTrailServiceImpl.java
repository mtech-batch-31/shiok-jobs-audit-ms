package com.mtech.sjmsaudit.service;

import com.mtech.sjmsaudit.entity.AuditTrail;
import com.mtech.sjmsaudit.repository.AuditTrailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuditTrailServiceImpl implements AuditTrailService {

    @Autowired
    private AuditTrailRepository auditTrailRepository;

    @Override
    public AuditTrail insertAuditTrail(AuditTrail auditTrail) {

        return auditTrailRepository.saveAndFlush(auditTrail);
    }
}
