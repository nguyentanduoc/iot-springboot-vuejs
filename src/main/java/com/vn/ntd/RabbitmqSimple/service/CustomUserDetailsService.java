package com.vn.ntd.RabbitmqSimple.service;

import com.vn.ntd.RabbitmqSimple.model.UserModel;
import com.vn.ntd.RabbitmqSimple.model.UserPrincipal;
import com.vn.ntd.RabbitmqSimple.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * The Class CustomUserDetailsService
 *
 * @author ntduoc
 * @since 6/10/2019
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
