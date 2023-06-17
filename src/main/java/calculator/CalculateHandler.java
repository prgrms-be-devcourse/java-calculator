package calculator;

import calculator.constant.ErrorMessage;
import calculator.engine.CalculatorEngine;
import calculator.handler.ICalculateHandler;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.stream.IntStream;

public class CalculateHandler implements ICalculateHandler {

    @Override
    public int calculate(String problem) {
        String[] parsedProblem = parseRawProblem(problem);
        return basicCalculate(priorityCalculate(parsedProblem));
    }

    private String[] parseRawProblem(String problem) {
        return problem.split(" ");
    }

    private int basicCalculate(String[] problem) {
        int initNum = Integer.parseInt(problem[0]);
        return IntStream.range(0, problem.length)
                .filter(i -> i % 2 != 0)
                .reduce(initNum, (acc, next) -> CalculatorEngine.execute(acc, Integer.parseInt(problem[next+1]), problem[next])
                        .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_OPERATOR)));

    }
    private String[] priorityCalculate(String[] problem) {
        Deque<String> deque1 = new ArrayDeque<>(List.of(problem));
        Deque<String> deque2 = new ArrayDeque<>();

        while (!deque1.isEmpty()) {
            String temp = deque1.removeFirst();
            
            if (temp.equals("/") || temp.equals("*")) {
                int o1 = Integer.parseInt(deque2.removeLast());
                int o2 = Integer.parseInt(deque1.removeFirst());

                deque2.addLast(CalculatorEngine.execute(o1, o2, temp)
                        .map(Object::toString)
                        .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.UNEXPECTED_ERROR)));

                continue;
            }
            
            deque2.addLast(temp);
        }
        return deque2.stream().toArray(String[]::new);
    }

}
