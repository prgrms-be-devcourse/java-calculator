package com.waterfogsw.service;

import com.waterfogsw.converter.Converter;
import com.waterfogsw.domain.Operator;
import com.waterfogsw.exception.DoubleOverflow;
import com.waterfogsw.exception.NotExistsOperator;
import com.waterfogsw.tokenizer.Tokenizer;
import lombok.AllArgsConstructor;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Stack;

@AllArgsConstructor
public class CalculationServiceImpl implements CalculationService {

    private final Tokenizer tokenizer;
    private final Converter converter;

    private final int DECIMAL_PLACES = 1000;
    private final double DECIMAL_PLACES_DOT = 1000.0;
    private final String DECIMAL_FORMAT_PATTERN = "#.##########";

    private final Double OVERFLOW = 9223372036854776D;

    private final String ZERO = "0";

    /**
     * 계산 메서드
     *
     * @param formula 계산식 문자열
     * @return 계산 결과값 문자열
     */
    @Override
    public String getResult(String formula) throws NullPointerException, NotExistsOperator, DoubleOverflow {
        List<String> infixTokens = tokenizer.tokenize(formula);
        List<String> postfixTokens = converter.convert(infixTokens);

        Stack<String> stack = new Stack<>();

        for (String token : postfixTokens) {
            if (!Operator.isOperator(token)) {
                // 숫자일 경우 stack에 넣기
                stack.add(token);
            } else if (stack.size() == 1) {
                // 연산자이고 stack에 숫자(피연산자)가 1개만 있는 경우
                // 피연산자 0이 있다는 가정하에 계산
                String x = stack.pop();
                String result = calculate(ZERO, x, Operator.MIN.getSymbol());

                stack.add(result);
            } else {
                // 2개의 피연산자를 뽑아낸다
                String x = stack.pop();
                String y = stack.pop();

                String result = calculate(y, x, token);
                stack.add(String.valueOf(result));
            }
        }

        String result = round(stack.pop());

        // 오버플로우 확인
        if (checkOverflow(result)) throw new DoubleOverflow();
        return result;
    }


    private String calculate(String x, String y, String op) throws NotExistsOperator, DoubleOverflow {
        Double xDouble = Double.parseDouble(x);
        Double yDouble = Double.parseDouble(y);

        // 연산자에 따른 계산 수행
        Operator operator = Operator.getOperator(op);
        Double result = operator.calculate(xDouble, yDouble);

        return String.valueOf(result);
    }

    // 소수점 자릿수 제한
    private String round(String num) {
        Double temp = Double.parseDouble(num);
        temp = Math.round((temp * DECIMAL_PLACES)) / DECIMAL_PLACES_DOT;

        DecimalFormat df = new DecimalFormat(DECIMAL_FORMAT_PATTERN);
        return df.format(temp);
    }

    private boolean checkOverflow(String num) {
        Double temp = Double.parseDouble(num);
        return temp.equals(OVERFLOW) || temp.equals(-1 * OVERFLOW);
    }
}
