package model.calculation;

import model.vo.CalculationResult;

import java.util.List;

public interface Calculation {
    CalculationResult calculate(List<String> postfixExpression);
}
