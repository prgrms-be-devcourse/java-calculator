package io;

import model.ExpressionVO;
import model.MenuVO;

public interface CalculatorInput {
    MenuVO menuInput();

    ExpressionVO expressionInput();
}
