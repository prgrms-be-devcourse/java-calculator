package io;

import model.vo.Expression;
import model.vo.Menu;

public interface CalculatorInput {
    Menu menuInput();

    Expression expressionInput();
}
