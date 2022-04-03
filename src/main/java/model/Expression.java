package model;

import util.StringUtils;

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * 수식 및 수식에 대한 결과값을 저장하는 클래스입니다.
 * 생성자를 통해 수식 객체 생성 시, 해당 수식이 유효한지 확인합니다.
 */
public class Expression {
    private static final String NUM_REGEX = "[0-9]+";
    private static final String OPERATOR_REGEX = "[+\\-*/]";
    private final String expression;
    private Double calcResult;

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
        String[] splitExp = StringUtils.splitByBlank(expression);
        validateOperatorNumberCount(splitExp);
        validateAllMatchWithRegex(splitExp);
    }

    private void validateAllMatchWithRegex(String[] splitExp) {
        Pattern pattern = Pattern.compile(NUM_REGEX + "|" + OPERATOR_REGEX);
        boolean isAllMatched = Arrays.stream(splitExp)
                .allMatch(e -> pattern.matcher(e).find());
        if(!isAllMatched) {
            throw new IllegalArgumentException("연산자 혹은 숫자만 입력해주세요");
        }
    }

    private void validateOperatorNumberCount(String[] splitExp) {
        long numCnt = Arrays.stream(splitExp)
                .filter(exp -> exp.matches(NUM_REGEX))
                .count();
        long operatorCnt = Arrays.stream(splitExp)
                .filter(exp -> exp.matches(OPERATOR_REGEX))
                .count();
        if(numCnt != operatorCnt+1) {
            throw new IllegalArgumentException("연산자와 숫자가 제대로 입력되지 않았습니다.");
        }
    }
}
