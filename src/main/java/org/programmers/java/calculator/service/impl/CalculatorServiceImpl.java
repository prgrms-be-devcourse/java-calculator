package org.programmers.java.calculator.service.impl;


import lombok.RequiredArgsConstructor;
import org.programmers.java.calculator.repository.impl.CalculatorRepositoryImpl;
import org.programmers.java.calculator.service.CalculatorService;

@RequiredArgsConstructor
public class CalculatorServiceImpl implements CalculatorService {

    private final CalculatorRepositoryImpl calculatorRepositoryImpl;

}
