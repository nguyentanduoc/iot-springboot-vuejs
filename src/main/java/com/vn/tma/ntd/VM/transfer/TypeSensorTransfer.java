package com.vn.tma.ntd.VM.transfer;

import com.vn.tma.ntd.VM.dto.TypeSensorDTO;
import com.vn.tma.ntd.VM.model.TypeSensorModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * The Class TypeSensorTransfer
 *
 * @author ntduoc
 * @since 6/20/2019
 */
@Component
public class TypeSensorTransfer {

    @Autowired
    private ModelMapper modelMapper;

    public Set<TypeSensorDTO> list(Collection<TypeSensorModel> typeSensorModel) {
        return typeSensorModel.stream().map( model -> modelMapper.map( model, TypeSensorDTO.class ) ).collect( Collectors.toSet() );
    }
}
