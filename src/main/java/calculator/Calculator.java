package calculator;

import calculator.adapter.CalculatorAdapter;
import calculator.constant.ErrorMessage;
import calculator.io.Input;
import calculator.io.Output;

import java.util.Optional;

public class Calculator {

    private Input input;
    private Output output;
    private final static String OPTION_PATTERN = "^(1|2)$";

    public Calculator(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public void run() {

        while (true) {
            output.print("1. 조회\n2. 계산\n\n선택 : ");
            String optionInput = input.read();

            if (!isValidatedOption(optionInput)) {
                output.print(ErrorMessage.INVALID_OPTION);
                return;
            }

            try {
                Optional<String> result = CalculatorAdapter.handle(optionInput);

                result.ifPresentOrElse(
                        s -> output.print(s),
                        () -> output.print(ErrorMessage.UNEXPECTED_ERROR)
                );
            } catch (Exception e) {
                output.print(e.getMessage());
            }
        }
    }

    private boolean isValidatedOption(String input) {
        return input.matches(OPTION_PATTERN);
    }
}
