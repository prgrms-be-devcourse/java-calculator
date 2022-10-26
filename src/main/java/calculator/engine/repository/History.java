package calculator.engine.repository;

import calculator.engine.model.CalculationResult;
import calculator.engine.model.Expression;

import java.util.List;

public interface History {

    void record(Expression infix, CalculationResult result);

    List<String> getLiterals();
}
