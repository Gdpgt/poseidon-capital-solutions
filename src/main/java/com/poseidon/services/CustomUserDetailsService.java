package com.poseidon.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.poseidon.domain.User;
import com.poseidon.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User loadedUser = userRepository.findByUsername(username)
                                        .orElseThrow(
                                            () -> new UsernameNotFoundException("Username not found : " + username)
                                        );
        return org.springframework.security.core.userdetails.User.builder()
            .username(loadedUser.getUsername())
            .password(loadedUser.getPassword())
            .roles(loadedUser.getRole())
            .build();
    }
    
}
