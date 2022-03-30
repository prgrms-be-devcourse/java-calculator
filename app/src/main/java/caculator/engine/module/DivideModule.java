package caculator.engine.module;

import caculator.exception.CanNotDivideWithZeroException;

public class DivideModule implements CalculatorModule {
    @Override
    public float execute(float operand1, float operand2) throws CanNotDivideWithZeroException {
        float zero = 0;
        if (operand2 == zero) {
            throw new CanNotDivideWithZeroException("0으로 나눌 수 없습니다.");
        }
        return operand1 / operand2;
    }
}
