package com.vn.tma.ntd.VM.service.impl;

import com.vn.tma.ntd.VM.exception.BadRequestException;
import com.vn.tma.ntd.VM.model.UserModel;
import com.vn.tma.ntd.VM.repository.UserRepository;
import com.vn.tma.ntd.VM.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
            throw new BadRequestException( "Not found user " );
        }
    }
}
