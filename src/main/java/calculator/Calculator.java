package calculator;


import calculator.calculate.Calculation;
import calculator.io.Input;
import calculator.io.Output;
import calculator.io.Message;
import calculator.repository.Repository;
import lombok.AllArgsConstructor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@AllArgsConstructor
public class Calculator {

    private Input input;
    private Output output;
    private Repository repository;
    private Calculation calculation;

    /**
     * console 시작
     */
    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String command = input.input(Message.INPUT_MESSAGE.getMessage());
            switch (command) {
                case "1":
                    // findAll
                    if (repository.isEmpty()) output.output(Message.EMPTY_MESSAGE.getMessage());
                    else {
                        repository.findAll();
                        //output.output("\n");
                    }
                    break;
                case "2":
                    // calculate
                    String s = br.readLine();
                    String result = calculation.calculate(s);
                    if (result.equals(Message.CALCULATE_ERROR_MESSAGE.getMessage())) output.output(result);
                    else repository.save(s + " = " + result);
                    break;
                case "q":
                    output.inputError(Message.EXIT_MESSAGE.getMessage());
                    return;
                default:
                    output.inputError(Message.WRONG_INPUT_ERROR_MESSAGE.getMessage());
                    break;
            }
        }

    }

}
