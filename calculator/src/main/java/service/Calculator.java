package service;

import io.Input;
import io.Output;
import lombok.AllArgsConstructor;
import model.Operator;
import repository.Repository;
import util.GuideMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@AllArgsConstructor
public class Calculator {
    private final Repository repository;
    private final Input input;
    private final Output output;
    private final Validator validator;
    private final String NUMBER_PATTERN = "^[-]?[0-9]+$";
    private final int HUNDRED_PERCENT = 100;
    //소수점 둘째자리까지 반올림
    private final double DIGIT_PERCENT = 100.0;

    /**
     * @Method : input
     * @Description : 계산 입력 받고 결과 출력
     **/

    public void input() {
        System.out.print(GuideMessage.INPUT_EXPRESSION.getMessage());
        String line = input.readLine();
        double calculate = roundSecondDigitResult(calculate(line));
        repository.save(line, calculate);
        System.out.print(GuideMessage.OUTPUT_RESULT.getMessage());
        output.printResult(String.valueOf(calculate));
    }

    /**
     * @Method : getResults
     * @Description : DB 조회 결과 출력
     **/

    public void getResults() {
        List<String> results = repository.getResults();
        if (results.size() == 0)
            System.out.print(GuideMessage.OUTPUT_EMPTY.getMessage());
        else
            for (String result : results) output.printResult(result);
    }

    /**
     * @Method : calculate
     * @Description : 입력받은 식으로 계산
     * @Return : double
     **/

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
     * @Method : toPostfix
     * @Description : 중위표기식 -> 후위표기식
     * @Parameter : [expression]
     * @Return : String
     **/

    public ArrayList<Object> toPostfix(String expression) {
        ArrayList<Object> postFix = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        String[] splitExpression = expression.trim().split("\\s+");
        for (String value : splitExpression) {
            if (value.matches(NUMBER_PATTERN)) {
                double number = validator.validateDouble(value);
                postFix.add(number);
            } else {
                Operator.parse(value);
                while (!stack.isEmpty() && checkPriority(stack.peek(), value)) {
                    postFix.add(stack.pop());
                }
                stack.push(value);
            }
        }
        while (!stack.isEmpty()) postFix.add(stack.pop());
        validator.validateFormat(postFix);
        return postFix;
    }

    /**
     * @Method : checkPriority
     * @Description : 우선순위 비교
     * @Parameter : [peek,now]
     * @Return : boolean
     **/

    public boolean checkPriority(String peek, String now) {
        return Operator.parse(peek).getPriority() >= Operator.parse(now).getPriority();
    }

    /**
    * @Method : roundSecondDigitResult
    * @Description : 계산 결과를 소수 둘째 짜리로 반올림
    * @Parameter : [result]
    * @Return : Double
    **/
    public double roundSecondDigitResult(Double result) {
        return Math.round(result * HUNDRED_PERCENT) / DIGIT_PERCENT;
    }

}
