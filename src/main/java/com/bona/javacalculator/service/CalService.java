package com.bona.javacalculator.service;

import com.bona.javacalculator.model.InputAndAnswer;
import com.bona.javacalculator.repository.CalMemoryRepository;
import com.bona.javacalculator.repository.MemoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalService {

    MemoryRepository memoryRepository = new CalMemoryRepository();
    public List<InputAndAnswer> inquiry() {
        List<InputAndAnswer> all = memoryRepository.findAll();
        if (all.isEmpty()) {
            System.out.println("조회한 결과, 기록이 존재하지 않습니다.");
        }
        return all;

    }

    public void calculate() {
    }
}
