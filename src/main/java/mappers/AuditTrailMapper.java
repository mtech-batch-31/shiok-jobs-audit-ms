package mappers;

import com.mtech.sjmsaudit.model.AuditTrailDto;
import com.mtech.sjmsaudit.entity.AuditTrail;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuditTrailMapper {

    AuditTrailMapper INSTANCE = Mappers.getMapper(AuditTrailMapper.class);

    @Mapping(target="accessTime", source="accessTime")
    @Mapping(target="id", ignore = true)
    AuditTrail auditTrailDtoToAuditTrail(AuditTrailDto dto);
}
