package com.poseidon.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.poseidon.domain.Trade;
import com.poseidon.repositories.TradeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TradeService {

    private final TradeRepository tradeRepository;


    public Optional<Trade> findById(int id) {
        return tradeRepository.findById(id);
    }

    public List<Trade> findAll() {
        return tradeRepository.findAll();
    }

    public Trade save(Trade trade) {
        return tradeRepository.save(trade);
    }

    public void deleteById(Integer id) {
        tradeRepository.deleteById(id);
    }
    
}
