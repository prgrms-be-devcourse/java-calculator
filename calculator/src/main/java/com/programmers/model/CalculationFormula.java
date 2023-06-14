package com.programmers.model;

import static com.programmers.converter.PostfixToAnswer.PostfixToAnswer;

import com.programmers.converter.InfixToPostfix;

public class CalculationFormula {

  private static final History history = new History();
  private static final Menu menu = new Menu();

  public void showResult() {
    // 저장한 계산결과 출력
    history.showHistory();
  }

  public void calculate(String infix) {
    String replacedInfix = menu.getReplacedInfix(infix);
    // 중위 표기식 -> 후위 표기식
    String postfix = InfixToPostfix.convertToPostfix(replacedInfix);
    // 후위 표기식 계산
    Double answer = PostfixToAnswer(postfix);
    // 계산 결과 출력
    System.out.println(answer + "\n");
    // 계산 결과 저장
    history.save(infix, answer);
  }


}
