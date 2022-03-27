package com.caculator;

import com.caculator.io.Input;
import com.caculator.io.Output;
import com.caculator.repository.CalculatorRepository;
import com.caculator.dto.Result;

import java.util.List;
import java.util.Stack;

import static com.caculator.ErrorMsg.*;

public class Calculator {

    private final CalculatorRepository repository;
    private final Input input;
    private final Output output;
    private static final String CMD_HISTORY = "1", CMD_CALCULATE = "2", CMD_EXIT = "-1";

    public Calculator(CalculatorRepository repository, Input input, Output output) {
        this.repository = repository;
        this.input = input;
        this.output = output;
    }

    public void run() {
        while (true) {
            String cmd = input.inputCmd();

            if (cmd.equals(CMD_HISTORY)) {
                List<Result> history = repository.findAll();

                if (history.size() == 0){
                    output.printError(EMPTY_HISTORY_MSG);
                    continue;
                }

                output.printHistory(history);
            } else if (cmd.equals(CMD_CALCULATE)) {
                String exp = input.inputExp();

                try {
                    int result = calculate(exp);
                    repository.save(new Result(exp, result));
                    output.printResult(result);
                } catch (IllegalArgumentException e) {
                    output.printError(INCORRECT_EXP_ERR_MSG);
                } catch (ArithmeticException e) {
                    output.printError(DIVIDE_ZERO_ERR_MSG);
                }
            } else if (cmd.equals(CMD_EXIT)) {
                return;
            } else {
                output.printError(INCORRECT_CMD_ERR_MSG);
            }
        }
    }

    public int calculate(String exp) throws IllegalArgumentException, ArithmeticException {

        List<String> postfix = PostfixConverter.convert(exp);
        Stack<Integer> stack = new Stack<>();

        for (String s : postfix) {
            if (StringUtils.isNumber(s)) {
                stack.push(Integer.parseInt(s));
            } else {
                int n2 = stack.pop();
                int n1 = stack.pop();

                if (s.equals("+")) stack.push(n1 + n2);
                else if (s.equals("-")) stack.push(n1 - n2);
                else if (s.equals("*")) stack.push(n1 * n2);
                else stack.push(n1 / n2);
            }
        }

        return stack.pop();
    }
}
