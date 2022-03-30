package com.programmers.calculator.engine;

import com.programmers.calculator.engine.io.Input;
import com.programmers.calculator.engine.io.Output;
import com.programmers.calculator.engine.repository.CalculatorRepository;
import com.programmers.calculator.engine.repository.MemoryCalculatorRepository;
import com.programmers.calculator.engine.validation.Validator;
import lombok.AllArgsConstructor;

import java.util.*;

@AllArgsConstructor
public class Calculator implements Runnable{

    Input input;
    Output output;
    CalculatorRepository repository;
    Validator validator;

    @Override
    public void run() {
        while(true) {
            String option = input.optionInput();
            if(option.equals("1")) {
                List<String> list = repository.findAll();
                output.lookUp(list);
            } else if (option.equals("2")) {
                String inputString  = input.calculationInput();
                if (!validator.validate(inputString)) {
                    output.inputError();
                    continue;
                }
                Queue<String> parse = parse(inputString);
                Integer result = calculate(parse);

                System.out.println(result+"\n");
                save(inputString, result);
            } else {
                System.out.println("1,2 번 중 하나를 골라 주세요\n");
            }
        }

    }

    private void save(String inputString, Integer result) {
        String history = inputString + " = " + result;
        repository.save(history);
    }

    public Integer calculate(Queue<String> inputQueue) {
        Stack<String> stack = new Stack<>();
        Integer result = 0;
        while (!inputQueue.isEmpty()) {
            String poll = inputQueue.poll();
            if (isStringInteger(poll)) {
                stack.add(poll);
            } else {
                int x = Integer.parseInt(stack.pop());
                int y = Integer.parseInt(stack.pop());
                int z = 0;
                switch (poll) {
                    case "+":
                        z = y + x;
                        break;
                    case "-":
                        z = y - x;
                        break;
                    case "*":
                        z = y * x;
                        break;
                    case "/":
                        z = y / x;
                        break;
                }
                stack.add(z+"");
            }
        }
        return Integer.parseInt(stack.pop());
    }

    public Queue<String> parse(String inputString) {
        StringTokenizer st = new StringTokenizer(inputString, " ");
        Stack<String> operator = new Stack<>();
        Queue<String> queue = new LinkedList<>();
        while(st.hasMoreTokens()) {
            String str = st.nextToken();
            if (isStringInteger(str)) {
                queue.add(str);
            } else {
                Optional<Integer> priority1 = priority(str);
                Optional<Integer> priority2;
                if (operator.isEmpty()) {
                    priority2 = Optional.of(0);
                } else {
                    priority2 = priority(operator.peek());
                }
                if (priority1.get() < priority2.get()) {
                    while(!operator.isEmpty()) {
                        String pop = operator.pop();
                        queue.add(pop);
                    }
                }
                operator.push(str);
            }
        }
        while (!operator.isEmpty()) {
            queue.add(operator.pop());
        }
        return queue;
    }

    public Optional<Integer> priority(String str) {
        if(str.equals("+") || str.equals("-")) {
            return Optional.of(1);
        } else if (str.equals("*") || str.equals("/")) {
            return Optional.of(2);
        } else {
            return Optional.empty();
        }
    }

    public boolean isStringInteger(String str) {
        if(str.isEmpty()) return false;
        long count = str.chars().filter(Character::isDigit).count();
        if (count == 0) return false;
        return true;
    }
}
