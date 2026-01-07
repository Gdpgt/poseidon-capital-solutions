package com.poseidon.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.poseidon.domain.User;
import com.poseidon.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

/**
 * Custom implementation of Spring Security's UserDetailsService.
 * Loads user-specific data from the database for authentication and authorization.
 */
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    /**
     * Loads a user by their username from the database.
     * Converts the application User entity to Spring Security's UserDetails for authentication.
     *
     * @param username the username identifying the user whose data is required
     * @return a fully populated UserDetails object (never null)
     * @throws UsernameNotFoundException if the user could not be found in the database
     */
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
