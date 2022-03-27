package com.programmers.calculator;

import com.programmers.calculator.exception.NumberInputException;
import com.programmers.calculator.exception.ValidationException;
import com.programmers.calculator.repository.MemoryRepository;
import com.programmers.calculator.repository.Repository;
import com.programmers.calculator.util.Parser;
import com.programmers.calculator.util.io.Input;
import com.programmers.calculator.util.io.Output;
import com.programmers.calculator.vo.Formula;

import java.util.*;

public class Calculator implements Runnable {
    private static final Repository<Formula> REPOSITORY = MemoryRepository.getInstance();
    private final Input input;
    private final Output<Formula> output;
    private final String newline = System.getProperty("line.separator");

    public Calculator(Input input, Output<Formula> output) {
        this.input = input;
        this.output = output;
    }

    @Override
    public void run() {
        boolean flag = true;

        while (flag) {
            try {
                int commandNumber;
                commandNumber = input.inputNumber(
                        "1. 조회" + newline +
                                "2. 계산" + newline +
                                "3. 종료" + newline + newline +
                                "선택 : ");

                switch (commandNumber) {
                    case 1:
                        output.outputList(REPOSITORY.findAll());
                        break;
                    case 2:
                        String str = input.inputString("식 입력 : ");
                        Optional<Double> result = calculate(str);
                        if (result.isPresent()) {
                            System.out.println(result + newline);
                            REPOSITORY.save(new Formula(str, result.get()));
                        } else {
                            throw new ValidationException();
                        }
                        break;
                    case 3:
                        flag = false;
                        break;
                    default:
                        throw new NumberInputException();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage() + newline);
            }
        }
    }

    private Optional<Double> calculate(String str) {
        if (!isValidate(str)) {
            return Optional.empty();
        }

        String[] array = Parser.parse(str);
        System.out.println(Arrays.toString(array));

        return Optional.of(0.0);
    }

    private boolean isValidate(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (temp == '(') {
                stack.push(temp);
            } else if (temp == ')') {
                if (stack.empty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.empty();
    }
}
