package com.solequat.businesslogic.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.core.entity.User;
import com.core.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG =
            "Incorrect user ID or password. Try again";
    private final UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        log.info(String.format("UserDetailsServiceImpl: loading user with email %s", email));

        User user = userRepository
                .findByEmail(email)
                .orElseThrow(() -> new InternalAuthenticationServiceException(USER_NOT_FOUND_MSG));

        if (user.getIsActive() == null) {
            log.error(USER_NOT_FOUND_MSG);
            throw new InternalAuthenticationServiceException(USER_NOT_FOUND_MSG);
        }

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getEmail())
                .password(user.getPassword())
                .authorities(String.valueOf(user.getRole()))
                .build();
    }
}
