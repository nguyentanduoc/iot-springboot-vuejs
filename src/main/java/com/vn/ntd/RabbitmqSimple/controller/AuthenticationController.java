package com.vn.ntd.RabbitmqSimple.controller;

import com.vn.ntd.RabbitmqSimple.dto.AuthResponse;
import com.vn.ntd.RabbitmqSimple.dto.UserSubmit;
import com.vn.ntd.RabbitmqSimple.exception.ApiError;
import com.vn.ntd.RabbitmqSimple.model.UserModel;
import com.vn.ntd.RabbitmqSimple.security.JwtTokenProvider;
import com.vn.ntd.RabbitmqSimple.service.IRoleService;
import com.vn.ntd.RabbitmqSimple.service.IUserService;
import com.vn.ntd.RabbitmqSimple.transfer.UserTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * The Class AuthenticationController
 *
 * @author ntduoc
 * @since 6/10/2019
 */
@RestController
@RequestMapping(path = "/api/auth")
public class AuthenticationController {

    @Autowired
    private UserTransfer userTransfer;

    @Autowired
    private IUserService iUserService;

    @Autowired
    private IRoleService iRoleService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping(path = "/login")
    public ResponseEntity login(@RequestBody UserSubmit userSubmit) {
        return null;
    }

    @PostMapping(path = "/register")
    public ResponseEntity register(@RequestBody UserSubmit userSubmit) {

        Optional<UserModel> userModelOptional = iUserService.findUserOrEmail( userSubmit.getUsername() );
        if (userModelOptional.isPresent()) throw new ApiError( HttpStatus.BAD_REQUEST, "Username Or Email exist" );

        UserModel userModel = userTransfer.register( userSubmit );
        iUserService.saveUser( userModel );

        return new ResponseEntity( HttpStatus.OK );
    }
}
