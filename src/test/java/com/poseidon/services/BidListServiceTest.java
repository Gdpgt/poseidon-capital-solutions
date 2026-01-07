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

import com.poseidon.domain.BidList;
import com.poseidon.repositories.BidListRepository;

@ExtendWith(MockitoExtension.class)
class BidListServiceTest {

    @Mock
    BidListRepository bidListRepository;

    @InjectMocks
    BidListService bidListService;


    @Test
    void findById_shouldReturnExpectedBidList_whenIdExists() {
        // Prepare
        BidList preparedBidList = new BidList();
        when(bidListRepository.findById(1)).thenReturn(Optional.of(preparedBidList));
        
        // Act
        Optional<BidList> foundBidList = bidListService.findById(1);

        // Assert
        assertThat(foundBidList).contains(preparedBidList);
    }
    
    @Test
    void findById_shouldReturnEmptyOptional_whenIdDoesntExist() {
        // Prepare
        when(bidListRepository.findById(1)).thenReturn(Optional.empty());
        
        // Act
        Optional<BidList> foundBidList = bidListService.findById(1);

        // Assert
        assertTrue(foundBidList.isEmpty());
    }
    
    @Test
    void findAll_shouldReturnExpectedBidLists_whenTheyExist() {
        // Prepare
        BidList preparedBidList = new BidList();
        List<BidList> bidList = new ArrayList<>();
        bidList.add(preparedBidList);
        when(bidListRepository.findAll()).thenReturn(bidList);
        
        // Act
        List<BidList> foundBidList = bidListService.findAll();

        // Assert
        assertThat(foundBidList).contains(preparedBidList);
    }
    
    @Test
    void findAll_shouldReturnEmptyList_whenNoBidListsExist() {
        // Prepare
        when(bidListRepository.findAll()).thenReturn(new ArrayList<>());
        
        // Act
        List<BidList> foundBidList = bidListService.findAll();

        // Assert
        assertTrue(foundBidList.isEmpty());
    }
    
    @Test
    void save_shouldReturnSavedBidList() {
        // Prepare
        BidList preparedBidList = new BidList();
        when(bidListRepository.save(preparedBidList)).thenReturn(preparedBidList);
        
        // Act
        BidList savedBidList = bidListService.save(preparedBidList);

        // Assert
        assertEquals(preparedBidList, savedBidList);
    }
    
    @Test
    void deleteById_shouldCallRepository() {
        // Act
        bidListService.deleteById(1);

        // Assert
        verify(bidListRepository).deleteById(1);
    }

}
