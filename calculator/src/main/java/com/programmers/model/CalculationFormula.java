package com.programmers.model;

import com.programmers.converter.InfixToPostfix;

public class CalculationFormula {

  public void showResult() {
    // 저장한 계산결과 출력
    System.out.println("답은 이거");
  }

  public void calculate(String infix) {
    // 중위 표기식 -> 후위 표기식
    String postfix = InfixToPostfix.convertToPostfix(infix);
    // 후위 표기식 계산
    // 계산 결과 출력
    // 계산 결과 저장
  }


}
