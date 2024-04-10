package com.mtech.sjmsaudit.service;

import com.mtech.sjmsaudit.entity.AuditTrail;
import com.mtech.sjmsaudit.repository.AuditTrailRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.http.HttpStatus;

import java.util.Date;
import java.util.UUID;

public class AuditTrailServiceImplTest {

    @Mock
    private AuditTrailRepository auditTrailRepository;

    @InjectMocks
    private AuditTrailServiceImpl auditTrailService;

    @BeforeEach()
    private void init(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void givenInsertAuditTrail_returnAuditTrail(){
        var auditTrail = new AuditTrail();
        var userId = UUID.randomUUID().toString();
        var accessTime = new Date();
        var event = "Sign-In";
        var message = "user successfully sign-in";

        auditTrail.setAccountUuid(userId);
        auditTrail.setMessage(message);
        auditTrail.setStatus(HttpStatus.OK.toString());
        auditTrail.setAccessTime(accessTime);
        auditTrail.setEvent(event);

        Mockito.when(auditTrailRepository.saveAndFlush(Mockito.any())).thenAnswer(i -> i.getArguments()[0]);
        var auditTrailInserted = auditTrailService.insertAuditTrail(auditTrail);

        Assertions.assertNotNull(auditTrailInserted);

        //Assertions.assertTrue(auditTrailInserted.getId() > 0);
        Assertions.assertEquals(event, auditTrailInserted.getEvent());
        Assertions.assertEquals(accessTime.getTime(), auditTrailInserted.getAccessTime().getTime());
        Assertions.assertEquals(message, auditTrailInserted.getMessage());
        Assertions.assertNull(auditTrailInserted.getData());

        Mockito.verify(auditTrailRepository, Mockito.times(1)).saveAndFlush(ArgumentMatchers.any());
    }
}
