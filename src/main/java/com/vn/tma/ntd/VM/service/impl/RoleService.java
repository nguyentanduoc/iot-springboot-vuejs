package com.vn.tma.ntd.VM.service.impl;

import com.vn.tma.ntd.VM.constant.ERoleName;
import com.vn.tma.ntd.VM.dto.RoleDTO;
import com.vn.tma.ntd.VM.exception.ApiError;
import com.vn.tma.ntd.VM.model.RoleModel;
import com.vn.tma.ntd.VM.repository.RoleRepository;
import com.vn.tma.ntd.VM.service.IRoleService;
import com.vn.tma.ntd.VM.transfer.RoleTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * The Class RoleService
 *
 * @author ntduoc
 * @since 6/11/2019
 */
@Service
public class RoleService implements IRoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RoleTransfer roleTransfer;

    @Override
    public RoleModel getRoleUser() {
        Optional<RoleModel> roleModelOptional = roleRepository.findByName( ERoleName.USER );
        if (!roleModelOptional.isPresent()) throw new ApiError( HttpStatus.BAD_REQUEST, "not found role name USER" );
        return roleModelOptional.get();
    }

    @Override
    public Set<RoleDTO> findAll() {
        return roleTransfer.listRoleModelToRoleDTO( roleRepository.findAll() );
    }

    @Override
    public List<RoleModel> findByIds(Iterable<Long> ids) {
        return roleRepository.findAllById( ids );
    }
}
