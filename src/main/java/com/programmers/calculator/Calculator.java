package com.programmers.calculator;

import com.programmers.calculator.repository.MemoryRepository;
import com.programmers.calculator.repository.Repository;
import com.programmers.calculator.util.Parser;
import com.programmers.calculator.util.io.Input;
import com.programmers.calculator.util.io.Output;
import com.programmers.calculator.vo.Formula;

import java.util.Arrays;
import java.util.Optional;
import java.util.Stack;

public class Calculator implements Runnable {
    private static final Repository<Formula> REPOSITORY = MemoryRepository.getInstance();
    private final Input input;
    private final Output<Formula> output;

    public Calculator(Input input, Output<Formula> output) {
        this.input = input;
        this.output = output;
    }

    @Override
    public void run() {
        boolean flag = true;

        while (flag) {
            int commandNumber;

            try {
                commandNumber = input.inputNumber("1. 조회\n2. 계산\n3. 종료\n\n선택 : ");
            } catch (Exception e) {
                System.out.println(e.getMessage());
                continue;
            }
            System.out.println();
            switch (commandNumber) {
                case 1:
                    output.outputList(REPOSITORY.findAll());
                    break;
                case 2:
                    String str = input.inputString("식 입력 : ");
                    Optional<Double> result = calculate(str);
                    if (result.isEmpty()) {
                        System.out.println("계산식이 잘못 구성되어 있습니다.");
                        continue;
                    }
                    System.out.println(result);
                    REPOSITORY.save(new Formula(str, result.get()));
                    break;
                case 3:
                    flag = false;
                    break;
                default:
                    System.out.println("다시 입력해주세요.");
            }
            System.out.println();
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
