package com.vn.tma.ntd.VM.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * The Class SensorDTO
 *
 * @author ntduoc
 * @since 6/20/2019
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class SensorDTO {

    private UUID id;
    private TypeSensorDTO typeSensor;
    private UserDTO userModel;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
