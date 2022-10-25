package org.programmers.java.calculator.service.impl;


import lombok.RequiredArgsConstructor;
import org.programmers.java.calculator.model.Menu;
import org.programmers.java.calculator.repository.impl.CalculatorRepositoryImpl;
import org.programmers.java.calculator.service.CalculatorService;

@RequiredArgsConstructor
public class CalculatorServiceImpl implements CalculatorService {

    private final CalculatorRepositoryImpl calculatorRepositoryImpl;

    public String record() {
        StringBuffer sb = new StringBuffer();
        calculatorRepositoryImpl.findAll()
                .forEach(i -> sb.append(i).append("\n"));
        return sb.toString();
    }
}
