package com.vn.ntd.RabbitmqSimple.service.impl;

import com.vn.ntd.RabbitmqSimple.model.UserModel;
import com.vn.ntd.RabbitmqSimple.repository.UserRepository;
import com.vn.ntd.RabbitmqSimple.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * The Class UserService
 *
 * @author ntduoc
 * @since 6/10/2019
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

}
