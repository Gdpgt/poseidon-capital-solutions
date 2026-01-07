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

import com.poseidon.domain.CurvePoint;
import com.poseidon.repositories.CurvePointRepository;

@ExtendWith(MockitoExtension.class)
class CurvePointServiceTest {

    @Mock
    CurvePointRepository curvePointRepository;

    @InjectMocks
    CurvePointService curvePointService;


    @Test
    void findById_shouldReturnExpectedCurvePoint_whenIdExists() {
        // Prepare
        CurvePoint preparedCurvePoint = new CurvePoint();
        when(curvePointRepository.findById(1)).thenReturn(Optional.of(preparedCurvePoint));
        
        // Act
        Optional<CurvePoint> foundCurvePoint = curvePointService.findById(1);

        // Assert
        assertThat(foundCurvePoint).contains(preparedCurvePoint);
    }
    
    @Test
    void findById_shouldReturnEmptyOptional_whenIdDoesntExist() {
        // Prepare
        when(curvePointRepository.findById(1)).thenReturn(Optional.empty());
        
        // Act
        Optional<CurvePoint> foundCurvePoint = curvePointService.findById(1);

        // Assert
        assertTrue(foundCurvePoint.isEmpty());
    }
    
    @Test
    void findAll_shouldReturnExpectedCurvePoints_whenTheyExist() {
        // Prepare
        CurvePoint preparedCurvePoint = new CurvePoint();
        List<CurvePoint> curvePoint = new ArrayList<>();
        curvePoint.add(preparedCurvePoint);
        when(curvePointRepository.findAll()).thenReturn(curvePoint);
        
        // Act
        List<CurvePoint> foundCurvePoint = curvePointService.findAll();

        // Assert
        assertThat(foundCurvePoint).contains(preparedCurvePoint);
    }
    
    @Test
    void findAll_shouldReturnEmptyList_whenNoCurvePointsExist() {
        // Prepare
        when(curvePointRepository.findAll()).thenReturn(new ArrayList<>());
        
        // Act
        List<CurvePoint> foundCurvePoint = curvePointService.findAll();

        // Assert
        assertTrue(foundCurvePoint.isEmpty());
    }
    
    @Test
    void save_shouldReturnSavedCurvePoint() {
        // Prepare
        CurvePoint preparedCurvePoint = new CurvePoint();
        when(curvePointRepository.save(preparedCurvePoint)).thenReturn(preparedCurvePoint);
        
        // Act
        CurvePoint savedCurvePoint = curvePointService.save(preparedCurvePoint);

        // Assert
        assertEquals(preparedCurvePoint, savedCurvePoint);
    }
    
    @Test
    void deleteById_shouldCallRepository() {
        // Act
        curvePointService.deleteById(1);

        // Assert
        verify(curvePointRepository).deleteById(1);
    }

}
