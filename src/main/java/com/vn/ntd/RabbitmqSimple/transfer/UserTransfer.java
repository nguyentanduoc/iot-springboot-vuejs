package com.vn.ntd.RabbitmqSimple.transfer;

import com.vn.ntd.RabbitmqSimple.dto.AuthResponse;
import com.vn.ntd.RabbitmqSimple.dto.UserDto;
import com.vn.ntd.RabbitmqSimple.dto.UserSubmit;
import com.vn.ntd.RabbitmqSimple.model.RoleModel;
import com.vn.ntd.RabbitmqSimple.model.UserModel;
import com.vn.ntd.RabbitmqSimple.model.UserPrincipal;
import com.vn.ntd.RabbitmqSimple.security.JwtTokenProvider;
import com.vn.ntd.RabbitmqSimple.service.IRoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * The Class UserTransfer
 *
 * @author ntduoc
 * @since 6/10/2019
 */
@Component
public class UserTransfer {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private IRoleService iRoleService;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

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
