package service;

import io.Input;
import io.Output;
import lombok.AllArgsConstructor;
import model.Operator;
import repository.CalculatorRepository;

import java.util.*;

@AllArgsConstructor
public class CalculatorServiceImpl implements CalculatorService {
    private final CalculatorRepository repository;
    private final Input input;
    private final Output output;
    private static final Map<Character, Integer> priorityMap = new HashMap<Character,Integer>() {{
        put('+', 1);
        put('-', 1);
        put('*', 2);
        put('/', 2);
    }};
    @Override
    public void calculate() {
        String line = input.readLine();
        output.printResult(line);
    }

    @Override
    public void getResults() {
        output.printResult(repository.getResults().toString());
    }

    @Override
    public String toPostfix(String expression) {
        return "";
    }

    @Override
    public boolean checkPriority(Character peek, Character now) {
        return priorityMap.get(peek) < priorityMap.get(now);
    }

}
