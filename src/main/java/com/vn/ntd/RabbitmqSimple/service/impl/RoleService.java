package com.vn.ntd.RabbitmqSimple.service.impl;

import com.vn.ntd.RabbitmqSimple.model.RoleModel;
import com.vn.ntd.RabbitmqSimple.model.RoleName;
import com.vn.ntd.RabbitmqSimple.repository.RoleRepository;
import com.vn.ntd.RabbitmqSimple.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * The Class RoleService
 *
 * @author ntduoc
 * @since 6/10/2019
 */
@Service
public class RoleService implements IRoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public RoleModel getRoleUser() {
        Optional<RoleModel> roleModelOptional = roleRepository.findByName( RoleName.user );
        return roleModelOptional.get();
    }
}
