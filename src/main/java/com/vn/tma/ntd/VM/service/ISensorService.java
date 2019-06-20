package com.vn.tma.ntd.VM.service;

import com.vn.tma.ntd.VM.dto.SensorDTO;
import com.vn.tma.ntd.VM.dto.request.SensorCreateSubmit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * The Class ISensorService
 *
 * @author ntduoc
 * @since 6/20/2019
 */
public interface ISensorService {

    void saveSensor(SensorCreateSubmit sensorCreateSubmit);

    Page<SensorDTO> findSensorByUserModel_Id(Long id, Pageable pageable);
}
