package com.vn.tma.ntd.VM.service.impl;

import com.vn.tma.ntd.VM.dto.UserDTO;
import com.vn.tma.ntd.VM.dto.request.AccountSubmit;
import com.vn.tma.ntd.VM.exception.BadRequestException;
import com.vn.tma.ntd.VM.model.RoleModel;
import com.vn.tma.ntd.VM.model.UserModel;
import com.vn.tma.ntd.VM.repository.UserRepository;
import com.vn.tma.ntd.VM.service.IRoleService;
import com.vn.tma.ntd.VM.service.IUserService;
import com.vn.tma.ntd.VM.transfer.UserTransfer;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * The Class UserService
 *
 * @author ntduoc
 * @since 6/11/2019
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private IRoleService iRoleService;

    @Value("${spring.application.password_default}")
    private String passwordDefault;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserTransfer userTransfer;

    @Override
    public void saveUser(UserModel userModel) {
        userRepository.save( userModel );
    }

    @Override
    public Optional<UserModel> findUserOrEmail(String userName) {
        return userRepository.findByUsernameOrEmail( userName, userName );
    }

    @Override
    public UserModel findById(Long id) {
        Optional<UserModel> optionalUserModel = userRepository.findById( id );
        if (optionalUserModel.isPresent()) {
            return optionalUserModel.get();
        } else {
            throw new BadRequestException( "Not found user" );
        }
    }

    @Override
    public void createAccount(AccountSubmit accountSubmit) {
        Optional<UserModel> optionalUserModel = userRepository.findByUsernameOrEmail( accountSubmit.getUsername(), accountSubmit.getEmail() );
        if (!optionalUserModel.isPresent()) {
            Set<RoleModel> roleModels = new HashSet<>( iRoleService.findByIds( accountSubmit.getRoles() ) );
            UserModel userModel = new UserModel();
            BeanUtils.copyProperties( accountSubmit, userModel );
            userModel.setRoles( roleModels );
            userModel.setPassword( passwordEncoder.encode( passwordDefault ) );
            saveUser( userModel );
        } else {
            throw new BadRequestException( "Username Or Email exists!" );
        }
    }

    @Override
    public Page<UserDTO> findAllUser(Pageable pageable) {
        Page<UserModel> pageUserModel = userRepository.findAll( pageable );
        List<UserDTO> userDTOS = userTransfer.list( pageUserModel.getContent() );
        return new PageImpl<>( userDTOS, pageable, pageUserModel.getTotalPages() );
    }
}
