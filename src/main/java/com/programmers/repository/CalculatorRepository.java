package com.programmers.repository;

import com.programmers.dto.CalculatorDto;
import com.programmers.util.IdGenerator;

import java.util.LinkedHashMap;
import java.util.Map;

public class CalculatorRepository {
    private final Map<Integer, CalculatorDto> calculatorRepository = new LinkedHashMap<>();
    private final IdGenerator idGenerator = new IdGenerator();
    public CalculatorRepository(){

    }

    public int save(CalculatorDto dto){
        int key = idGenerator.generateId();
        calculatorRepository.put(key,dto);
        return key;
    }

}
