package com.vn.tma.ntd.VM.service.impl;

import com.vn.tma.ntd.VM.dto.TypeSensorDTO;
import com.vn.tma.ntd.VM.dto.request.TypeOfSensorSubmit;
import com.vn.tma.ntd.VM.exception.BadRequestException;
import com.vn.tma.ntd.VM.model.TypeSensorModel;
import com.vn.tma.ntd.VM.repository.TypeSensorRepository;
import com.vn.tma.ntd.VM.service.ITypeSensorService;
import com.vn.tma.ntd.VM.transfer.TypeSensorTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * The Class TypeSensorService
 *
 * @author ntduoc
 * @since 6/20/2019
 */
@Service
public class TypeSensorService implements ITypeSensorService {

    @Autowired
    private TypeSensorRepository typeSensorRepository;

    @Autowired
    private TypeSensorTransfer typeSensorTransfer;

    @Override
    public Set<TypeSensorDTO> findAll() {
        List<TypeSensorModel> typeSensorModelList = typeSensorRepository.findAll();
        return typeSensorTransfer.list( typeSensorModelList );
    }

    @Override
    public TypeSensorModel findById(Long id) {
        Optional<TypeSensorModel> typeSensorModel = typeSensorRepository.findById( id );
        if (!typeSensorModel.isPresent()) throw new BadRequestException( "Not found Type Sensor" );
        return typeSensorModel.get();
    }

    @Override
    public void save(TypeOfSensorSubmit typeOfSensorSubmit) {
        TypeSensorModel typeSensorModel = typeSensorTransfer.dtoSubmitToModel( typeOfSensorSubmit );
        typeSensorRepository.save( typeSensorModel );
    }

}
