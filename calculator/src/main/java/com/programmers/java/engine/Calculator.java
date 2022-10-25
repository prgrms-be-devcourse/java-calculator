package com.programmers.java.engine;

import com.programmers.java.engine.model.Answer;
import com.programmers.java.engine.model.Expression;
import com.programmers.java.engine.model.MenuType;

import java.util.Optional;

public interface Calculator {
    // 식으로 값 계산 (후위 연산 변환 + 계산)
    Answer calculate(Expression expression);

    // 후위연산으로 계산
    Answer getResult(String[] postTokens);

    // 후위 연산으로 변환
    String[] makePostfix(String[] tokens);

    // 사용자의 식을 Expression 으로 변환
    Optional<Expression> parseExpression(String inputExpression);

    // 사용자의 옵션을 Integer 로 변환
    Optional<MenuType> parseOption(String inputOption);


}
