package caculator.engine.module;

public class PlusModule implements CalculatorModule {
    @Override
    public float execute(float operand1, float operand2) {
        return operand1 + operand2;
    }
}
