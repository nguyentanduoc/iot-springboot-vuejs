package com.vn.tma.ntd.VM.transfer;

import com.vn.tma.ntd.VM.dto.MenuDTO;
import com.vn.tma.ntd.VM.dto.UserDTO;
import com.vn.tma.ntd.VM.dto.request.UserSubmit;
import com.vn.tma.ntd.VM.model.RoleModel;
import com.vn.tma.ntd.VM.model.UserModel;
import com.vn.tma.ntd.VM.model.UserPrincipal;
import com.vn.tma.ntd.VM.service.IRoleService;
import com.vn.tma.ntd.VM.service.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

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

    @Autowired
    private IUserService iUserService;

    @Autowired
    private MenuTransfer menuTransfer;

    public UserModel register(UserSubmit userSubmit) {
        UserModel userModel = modelMapper.map( userSubmit, UserModel.class );
        RoleModel roleModel = iRoleService.getRoleUser();
        Set<RoleModel> roleModels = new HashSet<>();
        roleModels.add( roleModel );
        userModel.setPassword( passwordEncoder.encode( userModel.getPassword() ) );
        userModel.setRoles( roleModels );
        return userModel;
    }

    public UserDTO authenticationToUserDTO(Authentication authentication) {
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        Long userId = userPrincipal.getId();
        UserModel userModel = iUserService.findById( userId );
        Set<RoleModel> roleModels = userModel.getRoles();
        Set<MenuDTO> menuRoleDTOs = new HashSet<>();
        roleModels.forEach( roleModel -> menuRoleDTOs.addAll( menuTransfer.listModelToDto( roleModel.getMenuRoles() ) ) );
        Set<MenuDTO> sortMenuRoleDTOs = menuRoleDTOs.stream().sorted( Comparator.comparing( MenuDTO::getSortNum )).collect( Collectors.toCollection( LinkedHashSet::new ) );
        UserDTO userDTO = modelMapper.map( userModel, UserDTO.class );
        userDTO.setMenuDTOS( sortMenuRoleDTOs );
        return userDTO;
    }
}
