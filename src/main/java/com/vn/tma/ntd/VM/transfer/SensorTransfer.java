package com.vn.tma.ntd.VM.transfer;

import com.vn.tma.ntd.VM.dto.SensorDTO;
import com.vn.tma.ntd.VM.dto.request.SensorCreateSubmit;
import com.vn.tma.ntd.VM.model.SensorModel;
import com.vn.tma.ntd.VM.model.TypeSensorModel;
import com.vn.tma.ntd.VM.model.UserModel;
import com.vn.tma.ntd.VM.service.IUserService;
import com.vn.tma.ntd.VM.service.impl.TypeSensorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The Class SensorTransfer
 *
 * @author ntduoc
 * @since 6/20/2019
 */
@Component
public class SensorTransfer {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private TypeSensorService typeSensorService;

    @Autowired
    private ModelMapper modelMapper;

    public SensorModel objectSubmitToModel(SensorCreateSubmit sensorCreateSubmit) {
        SensorModel sensorModel = new SensorModel();
        TypeSensorModel typeSensorModel = typeSensorService.findById( sensorCreateSubmit.getTypeSensor() );
        UserModel userModel = iUserService.findById( sensorCreateSubmit.getAccount() );
        sensorModel.setUserModel( userModel );
        sensorModel.setTypeSensor( typeSensorModel );
        return sensorModel;
    }

    public List<SensorDTO> list(Collection<SensorModel> sensorModels) {
        return sensorModels.stream().map( sensorModel -> modelMapper.map( sensorModel, SensorDTO.class ) ).collect( Collectors.toList() );
    }
}
