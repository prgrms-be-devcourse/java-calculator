package org.programmers.calculator.TypeChecker;

import org.programmers.calculator.postfixCalculator.PostfixSolver;

import java.util.Map;

/**
 * 연산 및 파싱에서 피연산자와 연산자를 구별해내는 역할을 담당한다.
 * 연산자 순위 설정은 후위표기법 파싱에 영향을 줄 수 있다.
 * 새 종류의 피연산자 및 연산자를 구현하는 경우
 * 1. 이 클래스에서 연산자 및 피연산자 구별을 추가하며
 * 2. {@link org.programmers.calculator.postfixParser.PostfixParser}를 구현하여 알맞은 파싱 방식을 제공해야 하고
 * 3. 후위표기법으로 변환된 표현식을 풀이할 {@link PostfixSolver}를 구현하라.
 * 4. {@link org.programmers.calculator.configuration.CalculationUtilityFactory}를 구현하여 세 요소를 만들게 하라.
 */

public interface TypeChecker {

    boolean isOperand(String value);
    boolean isOperator(String value);

    Map<String, Integer> getOperatorRank();
}
