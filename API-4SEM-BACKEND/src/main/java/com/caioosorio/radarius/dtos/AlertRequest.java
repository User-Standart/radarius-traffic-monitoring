package com.caioosorio.radarius.dtos.request;

import com.caioosorio.radarius.enums.SourceTypeEnum;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class AlertRequest {
    private Integer criterionId;
    private Integer protocolId;
    private Short level;
    private String status;
    private Integer assignedToId;
    private String message;
    private String conclusion;
    private Integer cameraId;
    private OffsetDateTime createdAt;
    private SourceTypeEnum sourceType;
}
