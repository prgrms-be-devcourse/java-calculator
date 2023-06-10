package org.example.engine.repository;

import org.example.engine.model.CalculationResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.CacheRequest;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class InmemoryCalculationRepositoryTest {
    CalculationRepository calculationRepository;
    @BeforeEach
    void setup(){
        this.calculationRepository = new InmemoryCalculationRepository();
    }
    @Test
    void save() {
        String expression = "1 + 2 + 3";
        Double result = 6.0;
        CalculationResult calculationResult = new CalculationResult(expression, result);
        assertEquals(0L, calculationRepository.save(calculationResult));
    }
    @Test
    void findAll() {
        String expression = "1 + 2 + 3";
        Double result = 6.0;
        for(int i =0; i<10; i++){
            calculationRepository.save(new CalculationResult(expression, result));
        }
        assertEquals(10, calculationRepository.findAll().size());
    }
    @Test
    void clear() {
        String expression = "1 + 2 + 3";
        Double result = 6.0;
        for(int i =0; i<10; i++){
            calculationRepository.save(new CalculationResult(expression, result));
        }
        calculationRepository.clear();
        assertEquals(0, calculationRepository.size());
    }
}