package com.poseidon.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.poseidon.domain.User;
import com.poseidon.repositories.UserRepository;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;


    @Test
    void findById_shouldReturnExpectedUser_whenIdExists() {
        // Prepare
        User preparedUser = new User();
        when(userRepository.findById(1)).thenReturn(Optional.of(preparedUser));
        
        // Act
        Optional<User> foundUser = userService.findById(1);

        // Assert
        assertThat(foundUser).contains(preparedUser);
    }
    
    @Test
    void findById_shouldReturnEmptyOptional_whenIdDoesntExist() {
        // Prepare
        when(userRepository.findById(1)).thenReturn(Optional.empty());
        
        // Act
        Optional<User> foundUser = userService.findById(1);

        // Assert
        assertTrue(foundUser.isEmpty());
    }
    
    @Test
    void findAll_shouldReturnExpectedUsers_whenTheyExist() {
        // Prepare
        User preparedUser = new User();
        List<User> user = new ArrayList<>();
        user.add(preparedUser);
        when(userRepository.findAll()).thenReturn(user);
        
        // Act
        List<User> foundUser = userService.findAll();

        // Assert
        assertThat(foundUser).contains(preparedUser);
    }
    
    @Test
    void findAll_shouldReturnEmptyList_whenNoUsersExist() {
        // Prepare
        when(userRepository.findAll()).thenReturn(new ArrayList<>());
        
        // Act
        List<User> foundUser = userService.findAll();

        // Assert
        assertTrue(foundUser.isEmpty());
    }
    
    @Test
    void save_shouldReturnSavedUser() {
        // Prepare
        User preparedUser = new User();
        when(userRepository.save(preparedUser)).thenReturn(preparedUser);
        
        // Act
        User savedUser = userService.save(preparedUser);

        // Assert
        assertEquals(preparedUser, savedUser);
    }
    
    @Test
    void deleteById_shouldCallRepository() {
        // Act
        userService.deleteById(1);

        // Assert
        verify(userRepository).deleteById(1);
    }

}
