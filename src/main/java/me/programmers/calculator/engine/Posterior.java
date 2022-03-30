package me.programmers.calculator.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Posterior {

    // 후위표기식 변환
    public static List<String> convertToPosterior(String medianProblem) {
        Stack<String> opStack = new Stack<>();
        List<String> posteriorList = new ArrayList<>();
        List<String> medianProblemList = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(medianProblem, "+-*/", true);

        while (st.hasMoreTokens())  {
            medianProblemList.add(st.nextToken());
        }

        for (String s : medianProblemList) {
            if (Operator.isOperator(s.charAt(0))) {
                while (!opStack.isEmpty() &&
                        (Operator.getPriority(opStack.peek().charAt(0)) <= Operator.getPriority(s.charAt(0)))) {
                    posteriorList.add(opStack.pop());
                }
                opStack.push(s);
            } else {
                posteriorList.add(s);
            }
        }

        while (!opStack.isEmpty())
            posteriorList.add(opStack.pop());

        return posteriorList;
    }
}
