package calculator.handlermanager;

import calculator.handler.CalculatorHandler;

import java.util.HashMap;
import java.util.Map;

public class CalculatorHandlerManager implements ICalculatorHandlerManager{

    public final Map<String, CalculatorHandler> handlerMap = new HashMap<>();

    @Override
    public void registerHandler(String option, CalculatorHandler handler) {
        handlerMap.put(option, handler);
    }

    @Override
    public void execute(String option, Map<String, String> param, Map<String, Object> model) {
        handlerMap.get(option).process(param, model);
    }
}
