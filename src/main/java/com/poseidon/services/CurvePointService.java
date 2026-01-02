package com.poseidon.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.poseidon.domain.CurvePoint;
import com.poseidon.repositories.CurvePointRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CurvePointService {

    private final CurvePointRepository curvePointRepository;


    public Optional<CurvePoint> findById(int id) {
        return curvePointRepository.findById(id);
    }

    public List<CurvePoint> findAll() {
        return curvePointRepository.findAll();
    }

    public CurvePoint save(CurvePoint curvePoint) {
        return curvePointRepository.save(curvePoint);
    }

    public void deleteById(Integer id) {
        curvePointRepository.deleteById(id);
    }
    
}
