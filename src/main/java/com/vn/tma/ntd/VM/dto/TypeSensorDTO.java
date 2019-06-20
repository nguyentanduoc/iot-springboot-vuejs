package com.vn.tma.ntd.VM.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class TypeSensorDto
 *
 * @author ntduoc
 * @since 6/20/2019
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeSensorDTO {

    private Long id;
    private String name;
    private String detail;
}
