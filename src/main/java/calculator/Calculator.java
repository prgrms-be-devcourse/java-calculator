package calculator;

import calculator.constant.ErrorMessage;
import calculator.constant.ModelKey;
import calculator.constant.Option;
import calculator.constant.ParamKey;
import calculator.handler.CalculateHandler;
import calculator.handler.LookupHandler;
import calculator.handlermanager.ICalculatorHandlerManager;
import calculator.io.Input;
import calculator.io.Output;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calculator {

    private final Input input;
    private final Output output;
    private final ICalculatorHandlerManager handlerManager;
    private final String OPTION_PATTERN = "^(1|2)$";
    private final String MATH_PROBLEM_PATTERN = "^\\d+(\\s[+\\-*/]\\s\\d+)+$";

    public Calculator(Input input, Output output, ICalculatorHandlerManager handlerManager) {
        this.input = input;
        this.output = output;
        this.handlerManager = handlerManager;

        registerHandlers();
    }

    private void registerHandlers() {
        handlerManager.registerHandler(Option.LOOKUP, new LookupHandler());
        handlerManager.registerHandler(Option.CALCULATE, new CalculateHandler());
    }

    public void run() {

        while (true) {
            output.print("1. 조회\n2. 계산\n\n선택 : ");
            String optionInput = input.read();

            try {
                checkValidatedOption(optionInput);

                Map<String, String> param = new HashMap<>();
                Map<String, Object> model = new HashMap<>();

                switch (optionInput) {
                    case Option.LOOKUP:
                        executeLookupHandler(param, model);
                        output.print((List<Object>) model.get(ModelKey.LIST));
                        break;
                    case Option.CALCULATE:
                        param.put(ParamKey.PROBLEM, getProblemInput());
                        executeCalculateHandler(param, model);
                        output.print(String.valueOf(model.get(ModelKey.ANSWER)));
                        break;
                    default:
                        output.print(ErrorMessage.INVALID_OPTION);
                        return;
                }
            } catch (Exception e) {
                output.print(e.getMessage());
                return;
            }
        }
    }

    private String getProblemInput() {
        String problemInput = input.read();
        checkValidatedMathProblem(problemInput);
        return problemInput;
    }

    private void executeLookupHandler(Map<String, String> param, Map<String, Object> model) {
        handlerManager.execute(Option.LOOKUP, new HashMap<>(param), model);
    }

    private void executeCalculateHandler(Map<String, String> param, Map<String, Object> model) {
        handlerManager.execute(Option.CALCULATE, new HashMap<>(param), model);
    }


    private void checkValidatedOption(String input) {
        if (!input.matches(OPTION_PATTERN)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_OPTION);
        }
    }

    private void checkValidatedMathProblem(String input) {
        if (!input.matches(MATH_PROBLEM_PATTERN)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MATH_PROBLEM);
        }
    }
}
