package calculator;

import calculator.constant.ErrorMessage;
import calculator.constant.ModelKey;
import calculator.constant.ParamKey;
import calculator.handler.CalculateHandler;
import calculator.handler.LookupHandler;
import calculator.handlermanager.ICalculatorHandlerManager;
import calculator.io.Input;
import calculator.io.Output;
import calculator.vo.OptionVO;
import calculator.vo.ProblemVO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calculator {

    private final Input input;
    private final Output output;
    private final ICalculatorHandlerManager handlerManager;

    public Calculator(Input input, Output output, ICalculatorHandlerManager handlerManager) {
        this.input = input;
        this.output = output;
        this.handlerManager = handlerManager;

        registerHandlers();
    }

    private void registerHandlers() {
        handlerManager.registerHandler("1", new LookupHandler());
        handlerManager.registerHandler("2", new CalculateHandler());
    }

    public void run() {

        while (true) {
            output.print("1. 조회\n2. 계산\n\n선택 : ");

            try {
                String optionInput = getOptionInput();

                Map<String, String> param = new HashMap<>();
                Map<String, Object> model = new HashMap<>();

                switch (optionInput) {
                    case "1":
                        handlerManager.execute(optionInput, new HashMap<>(param), model);
                        output.print((List<Object>) model.get(ModelKey.LIST));
                        break;
                    case "2":
                        param.put(ParamKey.PROBLEM, getProblemInput());
                        handlerManager.execute(optionInput, new HashMap<>(param), model);
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
        return new ProblemVO(input.read()).get();
    }

    private String getOptionInput() {
        return new OptionVO(input.read()).get();
    }

}
