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

import com.poseidon.domain.Trade;
import com.poseidon.repositories.TradeRepository;

@ExtendWith(MockitoExtension.class)
class TradeServiceTest {

    @Mock
    TradeRepository tradeRepository;

    @InjectMocks
    TradeService tradeService;


    @Test
    void findById_shouldReturnExpectedTrade_whenIdExists() {
        // Prepare
        Trade preparedTrade = new Trade();
        when(tradeRepository.findById(1)).thenReturn(Optional.of(preparedTrade));
        
        // Act
        Optional<Trade> foundTrade = tradeService.findById(1);

        // Assert
        assertThat(foundTrade).contains(preparedTrade);
    }
    
    @Test
    void findById_shouldReturnEmptyOptional_whenIdDoesntExist() {
        // Prepare
        when(tradeRepository.findById(1)).thenReturn(Optional.empty());
        
        // Act
        Optional<Trade> foundTrade = tradeService.findById(1);

        // Assert
        assertTrue(foundTrade.isEmpty());
    }
    
    @Test
    void findAll_shouldReturnExpectedTrades_whenTheyExist() {
        // Prepare
        Trade preparedTrade = new Trade();
        List<Trade> trade = new ArrayList<>();
        trade.add(preparedTrade);
        when(tradeRepository.findAll()).thenReturn(trade);
        
        // Act
        List<Trade> foundTrade = tradeService.findAll();

        // Assert
        assertThat(foundTrade).contains(preparedTrade);
    }
    
    @Test
    void findAll_shouldReturnEmptyList_whenNoTradesExist() {
        // Prepare
        when(tradeRepository.findAll()).thenReturn(new ArrayList<>());
        
        // Act
        List<Trade> foundTrade = tradeService.findAll();

        // Assert
        assertTrue(foundTrade.isEmpty());
    }
    
    @Test
    void save_shouldReturnSavedTrade() {
        // Prepare
        Trade preparedTrade = new Trade();
        when(tradeRepository.save(preparedTrade)).thenReturn(preparedTrade);
        
        // Act
        Trade savedTrade = tradeService.save(preparedTrade);

        // Assert
        assertEquals(preparedTrade, savedTrade);
    }
    
    @Test
    void deleteById_shouldCallRepository() {
        // Act
        tradeService.deleteById(1);

        // Assert
        verify(tradeRepository).deleteById(1);
    }

}
