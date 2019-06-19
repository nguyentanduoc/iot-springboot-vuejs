package com.vn.tma.ntd.VM.service;

import com.vn.tma.ntd.VM.dto.UserDTO;
import com.vn.tma.ntd.VM.dto.request.AccountEditSubmit;
import com.vn.tma.ntd.VM.dto.request.AccountSubmit;
import com.vn.tma.ntd.VM.model.UserModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    void saveUser(UserModel userModel);

    Optional<UserModel> findUserOrEmail(String userName);

    UserModel findById(Long id);

    UserDTO createAccount(AccountSubmit accountSubmit);

    Page<UserDTO> findAllUser(Pageable pageable);

    UserDTO editAccount(AccountEditSubmit accountEditSubmit);
}
