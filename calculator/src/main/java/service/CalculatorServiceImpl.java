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

    /**
    * @Method : calculate
    * @Description : 입력받고 계산
    **/
    @Override
    public void calculate() {
        String line = input.readLine();
        output.printResult(line);
    }

    /**
    * @Method : getResults
    * @Description : DB 조회 결과 출력
    **/
    @Override
    public void getResults() {
        output.printResult(repository.getResults().toString());
    }

    /**
    * @Method : toPostfix
    * @Description : 중위표기식 -> 후위표기식
    * @Parameter : [expression]
    * @Return : String
    **/
    @Override
    public String toPostfix(String expression) {
        return "Hello";
    }

    /**
    * @Method : checkPriority
    * @Description : 우선순위 비교
    * @Parameter : [peek,now]
    * @Return : boolean
    **/
    @Override
    public boolean checkPriority(Character peek, Character now) {
        return priorityMap.get(peek) < priorityMap.get(now);
    }

}
