package com.programmers.model;

import static com.programmers.converter.PostfixToAnswer.PostfixToAnswer;

import com.programmers.converter.InfixToPostfix;

public class CalculationFormula {

  private static final History history = new History();
  private static final Menu menu = new Menu();

  public void showResult() {
    history.showHistory();
  }

  public void calculate(String infix) {
    String replacedInfix = menu.getReplacedInfix(infix);
    String postfix = InfixToPostfix.InfixToPostfix(replacedInfix);
    double answer = PostfixToAnswer(postfix);
    System.out.println(answer + "\n");
    history.save(infix, answer);
  }


}
