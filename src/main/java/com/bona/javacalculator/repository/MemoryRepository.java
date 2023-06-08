package com.bona.javacalculator.repository;

import com.bona.javacalculator.model.InputAndAnswer;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public interface MemoryRepository{

    InputAndAnswer save(InputAndAnswer inputAndAnswer);

    InputAndAnswer findById(Long id);

    List<InputAndAnswer> findAll();

    void clearStore();



    int size();

}
