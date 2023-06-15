package calculator.handlermanager;

import calculator.handler.CalculatorHandler;

import java.util.Map;

public interface ICalculatorHandlerManager {
    void registerHandler(String option, CalculatorHandler handler);
    void execute(String option, Map<String, String> param, Map<String, Object> model);
}
