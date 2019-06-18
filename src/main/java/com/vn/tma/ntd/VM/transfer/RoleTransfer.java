package com.vn.tma.ntd.VM.transfer;

import com.vn.tma.ntd.VM.dto.RoleDTO;
import com.vn.tma.ntd.VM.model.RoleModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * The Class RoleTransfer
 *
 * @author ntduoc
 * @since 6/17/2019
 */
@Component
public class RoleTransfer {

    @Autowired
    private ModelMapper modelMapper;

    public Set<RoleDTO> listRoleModelToRoleDTO(Collection<RoleModel> roleModels) {
        return roleModels.stream().map( role -> modelMapper.map( role, RoleDTO.class ) ).collect( Collectors.toSet() );
    }
}
