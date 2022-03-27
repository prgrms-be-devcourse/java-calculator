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
    private final Validator validator;
    private static final Map<Character, Integer> priorityMap = new HashMap<Character, Integer>() {{
        put('+', 1);
        put('-', 1);
        put('*', 2);
        put('/', 2);
    }};

    @Override
    public void input() {
        String line = input.readLine();
        double calculate = calculate(line);
        output.printResult(String.valueOf(calculate));
    }

    /**
     * @Method : calculate
     * @Description : 입력받은 식으로 계산
     **/
    @Override
    public double calculate(String line) {
        ArrayList<Object> postfix = toPostfix(line);
        Stack<Double> stack = new Stack<>();
        for (Object obj : postfix) {
            if (obj instanceof Double) {
                stack.push((Double) obj);
            } else {
                double b = stack.pop();
                double a = stack.pop();
                String op = (String) obj;
                Double result = Operator.parse(op).calculate(a, b);
                stack.push(result);
            }
        }
        return stack.pop();
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
    public ArrayList<Object> toPostfix(String expression) {
        ArrayList<Object> postFix = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        String tmp = "";
        Set<Character> characters = priorityMap.keySet();
        for (char c : expression.toCharArray()) {
            if (48 <= c && c <= 57) tmp += c;
            else {
                postFix.add(validator.validateDouble(tmp));
                validator.validateCharacter(characters, c);
                tmp = "";
                while (!stack.isEmpty() && checkPriority(stack.peek(), c)) {
                    postFix.add(String.valueOf(stack.pop()));
                }
                stack.push(c);
            }
        }
        if(!tmp.equals("")) postFix.add(Double.parseDouble(tmp));
        while (!stack.isEmpty()) postFix.add(String.valueOf(stack.pop()));
        validator.validateFormat(postFix);
        return postFix;
    }

    /**
     * @Method : checkPriority
     * @Description : 우선순위 비교
     * @Parameter : [peek,now]
     * @Return : boolean
     **/
    @Override
    public boolean checkPriority(Character peek, Character now) {
        return priorityMap.get(peek) >= priorityMap.get(now);
    }

}
