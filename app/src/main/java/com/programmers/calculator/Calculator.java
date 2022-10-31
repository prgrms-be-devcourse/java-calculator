package com.programmers.calculator;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calculator {

  private static final Map<Character, Integer> operationMap = new HashMap<>();

  public Double getAnswer(String input) {
    return calculatePostfix(toPostfix(input));
  }

  static {
    operationMap.put('*', 2);
    operationMap.put('/', 2);
    operationMap.put('+', 1);
    operationMap.put('-', 1);
  }

  private boolean compareOperatorPriorities(char oper1, char oper2) {
    int oper1Priority = operationMap.get(oper1);
    int oper2Priority = operationMap.get(oper2);

    return oper1Priority >= oper2Priority;
  }

  private boolean isNumeric(String str) {
    return str.matches("[0-9]+");
  }

  private List<Object> toPostfix(String input) {
    List<Object> postFix = new ArrayList<>();
    String[] calculationForm = input.split(" ");
    Deque<Character> collectionOfOpers = new ArrayDeque<>();

    for (String numericOrOper : calculationForm) {
      if (isNumeric(numericOrOper)) {
        postFix.add(Double.parseDouble(numericOrOper));

      } else {
        char oper = numericOrOper.charAt(0);

        OperPrecedenceComparison(postFix, collectionOfOpers, oper);
        collectionOfOpers.push(oper);

      }
    }
    while (!collectionOfOpers.isEmpty()) {
      postFix.add(collectionOfOpers.pop());
    }
    return postFix;
  }

  private void OperPrecedenceComparison(List<Object> postFix,
      Deque<Character> collectionOfOpers, char oper) {
    while (!collectionOfOpers.isEmpty() && compareOperatorPriorities(collectionOfOpers.peek(),
        oper)) {
      postFix.add(collectionOfOpers.pop());
    }
  }

  private Double calculatePostfix(List<Object> postfix) {
    Deque<Double> numbersStack = new ArrayDeque<>();
    for (Object numericOrOper : postfix) {
      if (numericOrOper instanceof Double num) {
        numbersStack.push(num);
      } else {
        Double preNum = numbersStack.pop();
        Double nextNum = numbersStack.pop();

        Character oper = (char) numericOrOper;
        numbersStack.push(Operation.calculate(oper, nextNum, preNum));
      }
    }
    return numbersStack.pop();
  }
}
