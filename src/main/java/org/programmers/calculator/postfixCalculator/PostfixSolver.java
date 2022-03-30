package org.programmers.calculator.postfixCalculator;

import java.util.List;

/**
 * 전달받은 후위표기식을 읽어, 답을 String으로 반환한다.
 */
public interface PostfixSolver {

    String solve(List<String> postfixExpression);
}
