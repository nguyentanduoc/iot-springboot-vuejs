package com.vn.tma.ntd.VM.service;

import com.vn.tma.ntd.VM.model.UserModel;
import com.vn.tma.ntd.VM.model.UserPrincipal;
import com.vn.tma.ntd.VM.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * The Class customUserDetailsService
 *
 * @author ntduoc
 * @since 6/11/2019
 */
@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserModel> userModelOptional = userRepository.findByUsernameOrEmail( username, username );
        if (!userModelOptional.isPresent())
            throw new UsernameNotFoundException( "User not found with username or email : " + username );
        return UserPrincipal.create( userModelOptional.get() );
    }

    public UserDetails loadUserById(Long id) {
        Optional<UserModel> userModelOptional = userRepository.findById( id );
        if (!userModelOptional.isPresent()) throw new UsernameNotFoundException( "User not found with id : " + id );
        return UserPrincipal.create( userModelOptional.get() );
    }
}
