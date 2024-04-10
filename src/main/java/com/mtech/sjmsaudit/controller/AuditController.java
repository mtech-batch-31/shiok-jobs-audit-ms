package com.mtech.sjmsaudit.controller;

import com.mtech.sjmsaudit.entity.AuditTrail;
import com.mtech.sjmsaudit.service.AuditTrailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/audit")
public class AuditController {

    @Autowired
    private AuditTrailServiceImpl auditTrailService;

    @PostMapping
    public ResponseEntity<AuditTrail> insertEvent(@RequestBody AuditTrail auditTrail){
        var response = auditTrailService.insertAuditTrail(auditTrail);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }
}
