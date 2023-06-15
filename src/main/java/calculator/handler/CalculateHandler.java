package calculator.handler;

import calculator.constant.ErrorMessage;
import calculator.constant.ModelKey;
import calculator.constant.ParamKey;
import calculator.engine.CalculatorEngine;

import java.util.Map;
import java.util.stream.IntStream;

public class CalculateHandler implements CalculatorHandler {

    @Override
    public void process(Map<String, String> param, Map<String, Object> model) {
        model.put(ModelKey.ANSWER, calculate(parseRawProblem(param.get(ParamKey.PROBLEM))));
    }

    private String[] parseRawProblem(String problem) {
        return problem.split(" ");
    }

    private int calculate(String[] problem) {
        int initNum = Integer.parseInt(problem[0]);
        return IntStream.range(0, problem.length)
                .filter(i -> i % 2 != 0)
                .reduce(initNum, (acc, next) -> CalculatorEngine.execute(acc, Integer.parseInt(problem[next+1]), problem[next])
                        .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_OPERATOR)));
    }

}
