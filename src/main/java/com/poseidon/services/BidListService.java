package com.poseidon.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.poseidon.domain.BidList;
import com.poseidon.repositories.BidListRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BidListService {

    private final BidListRepository bidListRepository;


    public Optional<BidList> findById(int id) {
        return bidListRepository.findById(id);
    }

    public List<BidList> findAll() {
        return bidListRepository.findAll();
    }

    public BidList save(BidList bidList) {
        return bidListRepository.save(bidList);
    }

    public void deleteById(Integer id) {
        bidListRepository.deleteById(id);
    }
    
}
