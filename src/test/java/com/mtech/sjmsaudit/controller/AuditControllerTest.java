package com.mtech.sjmsaudit.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mtech.sjmsaudit.entity.AuditTrail;
import com.mtech.sjmsaudit.service.AuditTrailServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Date;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@WebMvcTest(AuditController.class)
public class AuditControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuditTrailServiceImpl auditTrailService;

     @Test
    void givenInsertEvent_return201Response() throws Exception{
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

        ObjectMapper objectMapper = new ObjectMapper();
        var auditJsonString = objectMapper.writeValueAsString(auditTrail);

        mockMvc.perform(post("/v1/audit")
                .contentType(MediaType.APPLICATION_JSON)
                .content(auditJsonString))
                .andExpect(status().isCreated());

    }
}
