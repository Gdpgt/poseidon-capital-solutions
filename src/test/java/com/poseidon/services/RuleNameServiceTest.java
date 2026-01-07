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

import com.poseidon.domain.RuleName;
import com.poseidon.repositories.RuleNameRepository;

@ExtendWith(MockitoExtension.class)
class RuleNameServiceTest {

    @Mock
    RuleNameRepository ruleNameRepository;

    @InjectMocks
    RuleNameService ruleNameService;


    @Test
    void findById_shouldReturnExpectedRuleName_whenIdExists() {
        // Prepare
        RuleName preparedRuleName = new RuleName();
        when(ruleNameRepository.findById(1)).thenReturn(Optional.of(preparedRuleName));
        
        // Act
        Optional<RuleName> foundRuleName = ruleNameService.findById(1);

        // Assert
        assertThat(foundRuleName).contains(preparedRuleName);
    }
    
    @Test
    void findById_shouldReturnEmptyOptional_whenIdDoesntExist() {
        // Prepare
        when(ruleNameRepository.findById(1)).thenReturn(Optional.empty());
        
        // Act
        Optional<RuleName> foundRuleName = ruleNameService.findById(1);

        // Assert
        assertTrue(foundRuleName.isEmpty());
    }
    
    @Test
    void findAll_shouldReturnExpectedRuleNames_whenTheyExist() {
        // Prepare
        RuleName preparedRuleName = new RuleName();
        List<RuleName> ruleName = new ArrayList<>();
        ruleName.add(preparedRuleName);
        when(ruleNameRepository.findAll()).thenReturn(ruleName);
        
        // Act
        List<RuleName> foundRuleName = ruleNameService.findAll();

        // Assert
        assertThat(foundRuleName).contains(preparedRuleName);
    }
    
    @Test
    void findAll_shouldReturnEmptyList_whenNoRuleNamesExist() {
        // Prepare
        when(ruleNameRepository.findAll()).thenReturn(new ArrayList<>());
        
        // Act
        List<RuleName> foundRuleName = ruleNameService.findAll();

        // Assert
        assertTrue(foundRuleName.isEmpty());
    }
    
    @Test
    void save_shouldReturnSavedRuleName() {
        // Prepare
        RuleName preparedRuleName = new RuleName();
        when(ruleNameRepository.save(preparedRuleName)).thenReturn(preparedRuleName);
        
        // Act
        RuleName savedRuleName = ruleNameService.save(preparedRuleName);

        // Assert
        assertEquals(preparedRuleName, savedRuleName);
    }
    
    @Test
    void deleteById_shouldCallRepository() {
        // Act
        ruleNameService.deleteById(1);

        // Assert
        verify(ruleNameRepository).deleteById(1);
    }

}
