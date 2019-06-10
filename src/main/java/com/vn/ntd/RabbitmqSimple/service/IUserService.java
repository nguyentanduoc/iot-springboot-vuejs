package com.vn.ntd.RabbitmqSimple.service;

import com.vn.ntd.RabbitmqSimple.model.UserModel;

import java.util.Optional;

public interface IUserService {
    void saveUser(UserModel userModel);

    Optional<UserModel> findUserOrEmail(String userName);
}
