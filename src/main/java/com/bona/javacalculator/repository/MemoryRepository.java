package com.bona.javacalculator.repository;

import com.bona.javacalculator.model.ExpressionResult;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemoryRepository {

    ExpressionResult save(ExpressionResult expressionResult);

    ExpressionResult findById(Long id);

    List<ExpressionResult> findAll();


}
