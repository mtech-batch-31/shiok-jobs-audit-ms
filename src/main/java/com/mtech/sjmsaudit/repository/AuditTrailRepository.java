package com.mtech.sjmsaudit.repository;

import com.mtech.sjmsaudit.entity.AuditTrail;
import org.springframework.data.repository.CrudRepository;

public interface AuditTrailRepository extends CrudRepository<AuditTrail, Long> {

    <S extends AuditTrail> S save(S entity);
}
