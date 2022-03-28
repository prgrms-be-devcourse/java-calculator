package model;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Expression {
    private static final String NUM_REGEX = "[0-9]+";
    private static final String OPERATOR_REGEX = "[+\\-*/]";
    private final String expression;
    private Double calcResult = null;

    public Expression(String expression) {
        validateExpressions(expression);
        this.expression = expression;
    }

    public String getExpression() {
        return expression;
    }

    public Double getCalcResult() {
        return calcResult;
    }

    public void setCalcResult(Double calcResult) {
        this.calcResult = calcResult;
    }

    private void validateExpressions(String expression) {
        String[] splitExp = expression.split(" ");
        checkOperatorNumberCount(splitExp);
        checkOperatorNumberOrder(splitExp);
        checkAllMatchWithRegex(splitExp);
    }

    private void checkAllMatchWithRegex(String[] splitExp) {
        Pattern pattern = Pattern.compile(NUM_REGEX + "|" + OPERATOR_REGEX);
        boolean isAllMatched = Arrays.stream(splitExp)
                .allMatch(e -> pattern.matcher(e).find());
        if(!isAllMatched) throw new IllegalArgumentException("연산자 혹은 숫자만 입력해주세요");
    }

    private void checkOperatorNumberCount(String[] splitExp) {
        long numCnt = Arrays.stream(splitExp)
                .filter(exp -> exp.matches(NUM_REGEX))
                .count();
        long operatorCnt = Arrays.stream(splitExp)
                .filter(exp -> exp.matches(OPERATOR_REGEX))
                .count();
        if(numCnt != operatorCnt+1) throw new IllegalArgumentException("연산자와 숫자가 제대로 입력되지 않았습니다.");
    }

    private void checkOperatorNumberOrder(String[] splitExp) {
        for(int i = 0; i < splitExp.length; i++){
            if(splitExp[i].matches(OPERATOR_REGEX)){
                if(i == 0 || i == splitExp.length-1)
                    throw new IllegalArgumentException("연산자가 맨 앞 혹은 맨 뒤에 나왔습니다.");
                if(!splitExp[i -1].matches(NUM_REGEX)
                        || !splitExp[i +1].matches(NUM_REGEX)){
                    throw new IllegalArgumentException("연산자와 숫자의 순서를 확인해주세요.");
                }
            }
        }
    }
}
