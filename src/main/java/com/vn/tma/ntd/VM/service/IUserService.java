package com.vn.tma.ntd.VM.service;

import com.vn.tma.ntd.VM.model.UserModel;

import java.util.Optional;

public interface IUserService {
    void saveUser(UserModel userModel);

    Optional<UserModel> findUserOrEmail(String userName);
}
