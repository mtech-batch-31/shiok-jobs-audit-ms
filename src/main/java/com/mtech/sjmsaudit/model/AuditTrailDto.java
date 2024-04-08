package com.mtech.sjmsaudit.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuditTrailDto {
    private String accountUuid;
    private Date accessTime;
    private String event;
    private String status;
    private String message;
    private String data;
}
