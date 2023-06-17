package calculator;

import calculator.constant.ErrorMessage;
import calculator.handler.ICalculateHandler;
import calculator.handler.ILookupHandler;
import calculator.io.Input;
import calculator.io.Output;
import calculator.vo.Option;
import calculator.vo.Problem;

public class Calculator {

    private final Input input;
    private final Output output;
    private final ILookupHandler lookupHandler;
    private final ICalculateHandler calculateHandler;

    public Calculator(Input input, Output output, ILookupHandler lookupHandler, ICalculateHandler calculateHandler) {
        this.input = input;
        this.output = output;
        this.lookupHandler = lookupHandler;
        this.calculateHandler = calculateHandler;
    }

    public void run() {

        while (true) {
            output.print("1. 조회\n2. 계산\n\n선택 : ");

            try {
                String optionInput = getOptionInput();

                switch (optionInput) {
                    case "1":
                        output.print(lookupHandler.lookup());
                        break;
                    case "2":
                        output.print(String.valueOf(calculateHandler.calculate(getProblemInput())));
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
        return new Problem(input.read()).get();
    }

    private String getOptionInput() {
        return new Option(input.read()).get();
    }

}
