package com.vn.tma.ntd.VM.service;

import com.vn.tma.ntd.VM.dto.TypeSensorDTO;
import com.vn.tma.ntd.VM.model.TypeSensorModel;

import java.util.Set;

public interface ITypeSensorService {
    Set<TypeSensorDTO> findAll();

    TypeSensorModel findById(Long id);
}
