package calculator.engine;

@FunctionalInterface
public interface OperationHandler {
    int operate(int o1, int o2);
}
