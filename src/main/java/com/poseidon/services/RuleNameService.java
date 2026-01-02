package com.poseidon.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.poseidon.domain.RuleName;
import com.poseidon.repositories.RuleNameRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RuleNameService {

    private final RuleNameRepository ruleNameRepository;


    public Optional<RuleName> findById(int id) {
        return ruleNameRepository.findById(id);
    }

    public List<RuleName> findAll() {
        return ruleNameRepository.findAll();
    }

    public RuleName save(RuleName ruleName) {
        return ruleNameRepository.save(ruleName);
    }

    public void deleteById(Integer id) {
        ruleNameRepository.deleteById(id);
    }
    
}
