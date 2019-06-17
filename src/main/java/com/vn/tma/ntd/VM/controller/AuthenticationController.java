package com.vn.tma.ntd.VM.controller;

import com.vn.tma.ntd.VM.dto.UserDTO;
import com.vn.tma.ntd.VM.dto.request.UserSubmit;
import com.vn.tma.ntd.VM.dto.response.AuthResponse;
import com.vn.tma.ntd.VM.exception.ApiError;
import com.vn.tma.ntd.VM.exception.BadRequestException;
import com.vn.tma.ntd.VM.model.RoleModel;
import com.vn.tma.ntd.VM.model.UserModel;
import com.vn.tma.ntd.VM.model.UserPrincipal;
import com.vn.tma.ntd.VM.security.JwtTokenProvider;
import com.vn.tma.ntd.VM.service.IRoleService;
import com.vn.tma.ntd.VM.service.IUserService;
import com.vn.tma.ntd.VM.transfer.UserTransfer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.Set;

/**
 * The Class AuthenticationController
 *
 * @author ntduoc
 * @since 6/11/2019
 */
@RestController
@RequestMapping(path = "/api/auth")
public class AuthenticationController {

    @Autowired
    private UserTransfer userTransfer;

    @Autowired
    private IUserService iUserService;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping(path = "/login")
    public ResponseEntity login(@RequestBody UserSubmit userSubmit) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userSubmit.getUsername(),
                        userSubmit.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication( authentication );
        String jwt = jwtTokenProvider.generateToken( authentication );
        UserDTO userDTO = userTransfer.authenticationToUserDTO( authentication );
        return ResponseEntity.ok( new AuthResponse( jwt, userDTO ) );
    }

    @PostMapping(path = "/register")
    public ResponseEntity register(@RequestBody UserSubmit userSubmit) {

        Optional<UserModel> userModelOptional = iUserService.findUserOrEmail( userSubmit.getUsername() );
        if (userModelOptional.isPresent()) throw new BadRequestException( "Username Or Email exist" );

        UserModel userModel = userTransfer.register( userSubmit );
        iUserService.saveUser( userModel );

        return new ResponseEntity( HttpStatus.OK );
    }
}
