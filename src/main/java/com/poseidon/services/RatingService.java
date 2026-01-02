package com.poseidon.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.poseidon.domain.Rating;
import com.poseidon.repositories.RatingRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RatingService {

    private final RatingRepository ratingRepository;


    public Optional<Rating> findById(int id) {
        return ratingRepository.findById(id);
    }

    public List<Rating> findAll() {
        return ratingRepository.findAll();
    }

    public Rating save(Rating rating) {
        return ratingRepository.save(rating);
    }

    public void deleteById(Integer id) {
        ratingRepository.deleteById(id);
    }
    
}
