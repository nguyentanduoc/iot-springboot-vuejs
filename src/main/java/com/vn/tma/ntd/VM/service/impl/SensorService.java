package com.vn.tma.ntd.VM.service.impl;

import com.vn.tma.ntd.VM.dto.SensorDTO;
import com.vn.tma.ntd.VM.dto.request.SensorCreateSubmit;
import com.vn.tma.ntd.VM.model.SensorModel;
import com.vn.tma.ntd.VM.repository.SensorRepository;
import com.vn.tma.ntd.VM.service.ISensorService;
import com.vn.tma.ntd.VM.transfer.SensorTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The Class SensorService
 *
 * @author ntduoc
 * @since 6/20/2019
 */
@Service
public class SensorService implements ISensorService {

    @Autowired
    private SensorTransfer sensorTransfer;

    @Autowired
    private SensorRepository sensorRepository;

    @Override
    public void saveSensor(SensorCreateSubmit sensorCreateSubmit) {
        SensorModel sensorModel = sensorTransfer.objectSubmitToModel( sensorCreateSubmit );
        sensorModel.setEnabled( true );
        sensorRepository.save( sensorModel );
    }

    @Override
    public Page<SensorDTO> findSensorByUserModel_Id(Long id, Pageable pageable) {
        List<SensorModel> sensorModels = sensorRepository.findAllByUserModel_Id( id, pageable );
        List<SensorDTO> sensorDTOS = sensorTransfer.list( sensorModels );
        Long countRecord = sensorRepository.countAllByUserModel_Id( id );
        return new PageImpl<>( sensorDTOS, pageable, countRecord );
    }
}
