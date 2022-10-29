package com.programmers.java.engine.calculator;

import com.programmers.java.application.Operator;
import com.programmers.java.application.config.Validator;
import com.programmers.java.application.util.CalculatorUtils;
import com.programmers.java.application.util.PostfixUtils;
import com.programmers.java.engine.model.Answer;
import com.programmers.java.engine.model.Expression;
import lombok.AllArgsConstructor;

import java.util.*;

import static com.programmers.java.application.config.Constant.*;
import static com.programmers.java.application.util.CalculatorUtils.*;

@AllArgsConstructor
public class PostfixCalculator implements Calculator {

    private Validator validator;
    private PostfixUtils postfixUtils;

    @Override
    public Answer getAnswer(Expression expression) {

        // 후위연산으로 식 변경
        Expression postfixExpression = postfixUtils.makePostfix(expression);

        // 식 계산
        Answer result = calculate(postfixExpression);

        return result;
    }

    @Override
    public Answer calculate(Expression postfixExpression) {
        List<String> postTokens = postfixExpression.getTokens();
        Deque<Double> stack = new LinkedList<>();
        Double lhs = 0.0;
        Double rhs = 0.0;

        for (String token : postTokens) {
            if (CalculatorUtils.isMatchRegex(token, NUMBER_REGEX)) {
                stack.push(Double.parseDouble(token));
            } else if (isMatchRegex(token, ALL_OPERATOR_REGEX)) {
                rhs = stack.pop();
                lhs = stack.pop();

                Answer answer = Operator.calculate(token, lhs, rhs);
                stack.push(answer.getValue());
            }
        }

        return Answer.builder()
                .value(stack.peek())
                .build();
    }



    @Override
    public Expression parseExpression(String inputExpression) throws Exception {
        String nonSpaceExpression = makeNonSpaceString(inputExpression);

        validator.validateExpression(nonSpaceExpression);

        return Expression.builder()
                .tokens(numberOperatorTokenizer(nonSpaceExpression))
                .validator(validator)
                .build();
    }


}
