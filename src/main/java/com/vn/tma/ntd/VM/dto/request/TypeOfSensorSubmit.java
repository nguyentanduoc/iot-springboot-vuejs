package com.vn.tma.ntd.VM.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class TypeOfSensorSubmit
 *
 * @author ntduoc
 * @since 6/21/2019
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeOfSensorSubmit {
    private String name;
    private String detail;
}
