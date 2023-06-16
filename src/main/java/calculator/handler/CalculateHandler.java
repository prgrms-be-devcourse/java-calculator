package calculator.handler;

import calculator.constant.ErrorMessage;
import calculator.constant.ModelKey;
import calculator.constant.ParamKey;
import calculator.engine.CalculatorEngine;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class CalculateHandler implements CalculatorHandler {

    @Override
    public void process(Map<String, String> param, Map<String, Object> model) {
        int answer = calculate(parseRawProblem(param.get(ParamKey.PROBLEM)));
        model.put(ModelKey.ANSWER, answer);
    }

    private String[] parseRawProblem(String problem) {
        return problem.split(" ");
    }

    private int calculate(String[] problem) {
        return basicCalculate(priorityCalculate(problem));
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
