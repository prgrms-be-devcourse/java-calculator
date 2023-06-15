package calculator.handler;

import java.util.Map;

public interface CalculatorHandler {
    void process(Map<String, String> param, Map<String, Object> model);
}
