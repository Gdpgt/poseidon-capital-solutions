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

import com.poseidon.domain.Rating;
import com.poseidon.repositories.RatingRepository;

@ExtendWith(MockitoExtension.class)
class RatingServiceTest {

    @Mock
    RatingRepository ratingRepository;

    @InjectMocks
    RatingService ratingService;


    @Test
    void findById_shouldReturnExpectedRating_whenIdExists() {
        // Prepare
        Rating preparedRating = new Rating();
        when(ratingRepository.findById(1)).thenReturn(Optional.of(preparedRating));
        
        // Act
        Optional<Rating> foundRating = ratingService.findById(1);

        // Assert
        assertThat(foundRating).contains(preparedRating);
    }
    
    @Test
    void findById_shouldReturnEmptyOptional_whenIdDoesntExist() {
        // Prepare
        when(ratingRepository.findById(1)).thenReturn(Optional.empty());
        
        // Act
        Optional<Rating> foundRating = ratingService.findById(1);

        // Assert
        assertTrue(foundRating.isEmpty());
    }
    
    @Test
    void findAll_shouldReturnExpectedRatings_whenTheyExist() {
        // Prepare
        Rating preparedRating = new Rating();
        List<Rating> rating = new ArrayList<>();
        rating.add(preparedRating);
        when(ratingRepository.findAll()).thenReturn(rating);
        
        // Act
        List<Rating> foundRating = ratingService.findAll();

        // Assert
        assertThat(foundRating).contains(preparedRating);
    }
    
    @Test
    void findAll_shouldReturnEmptyList_whenNoRatingsExist() {
        // Prepare
        when(ratingRepository.findAll()).thenReturn(new ArrayList<>());
        
        // Act
        List<Rating> foundRating = ratingService.findAll();

        // Assert
        assertTrue(foundRating.isEmpty());
    }
    
    @Test
    void save_shouldReturnSavedRating() {
        // Prepare
        Rating preparedRating = new Rating();
        when(ratingRepository.save(preparedRating)).thenReturn(preparedRating);
        
        // Act
        Rating savedRating = ratingService.save(preparedRating);

        // Assert
        assertEquals(preparedRating, savedRating);
    }
    
    @Test
    void deleteById_shouldCallRepository() {
        // Act
        ratingService.deleteById(1);

        // Assert
        verify(ratingRepository).deleteById(1);
    }

}
