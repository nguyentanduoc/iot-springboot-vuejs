package com.vn.tma.ntd.VM.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class SensorCreateSubmit
 *
 * @author ntduoc
 * @since 6/20/2019
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SensorCreateSubmit {
    private Long account;
    private Long typeSensor;
}
