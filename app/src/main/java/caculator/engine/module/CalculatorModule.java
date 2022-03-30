package caculator.engine.module;

import caculator.exception.CanNotDivideWithZeroException;

public interface CalculatorModule {
    public float execute(float operand1, float operand2) throws CanNotDivideWithZeroException;
}
