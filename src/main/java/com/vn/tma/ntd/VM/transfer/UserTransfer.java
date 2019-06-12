package com.vn.tma.ntd.VM.transfer;

import com.vn.tma.ntd.VM.dto.request.UserSubmit;
import com.vn.tma.ntd.VM.model.RoleModel;
import com.vn.tma.ntd.VM.model.UserModel;
import com.vn.tma.ntd.VM.security.JwtTokenProvider;
import com.vn.tma.ntd.VM.service.IRoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * The Class UserTransfer
 *
 * @author ntduoc
 * @since 6/11/2019
 */
@Component
public class UserTransfer {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private IRoleService iRoleService;

    public UserModel register(UserSubmit userSubmit) {
        UserModel userModel = modelMapper.map( userSubmit, UserModel.class );
        RoleModel roleModel = iRoleService.getRoleUser();
        Set<RoleModel> roleModels = new HashSet<>();
        roleModels.add( roleModel );
        userModel.setPassword( passwordEncoder.encode( userModel.getPassword() ) );
        userModel.setRoles( roleModels );
        return userModel;
    }
}
