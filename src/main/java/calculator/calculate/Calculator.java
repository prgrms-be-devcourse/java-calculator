package calculator.calculate;

import calculator.console.Console;

import java.io.IOException;
import java.util.*;

public class Calculator {

    private final Console console;

    public Calculator(Console console) {
        this.console = console;
    }

//    public void run() throws IOException {
//        while(true) {
//            String expression = console.input();
//
//            if(!isValidExpression(expression)) {
//                console.print("유효하지 않은 식입니다.");
//            }
//            else {
//                Integer result = calculate(expression);
//                console.print(String.valueOf(result));
//            }
//        }
//    }

    public Integer calculate(String expr) {
        LinkedList<String> afterMulAndDiv = calMulAndDiv(expr);
        return calAddAndSub(afterMulAndDiv);
    }

    private Integer calAddAndSub(LinkedList<String> list) {
        Iterator<String> it = list.iterator();
        Integer ret = Integer.parseInt(it.next());
        while(it.hasNext()) {
            if(it.next().equals("+")) {
                ret += Integer.parseInt(it.next());
            } else {
                ret -= Integer.parseInt(it.next());
            }
        }
        return ret;
    }

    private LinkedList<String> calMulAndDiv(String expression) {
        LinkedList<String> list = new LinkedList<>();
        String[] exprTokens = expression.split(" ");
        for(int i = 0; i < exprTokens.length; i++) {
            if(0 < list.size() && (list.peekLast().equals("*") || list.peekLast().equals("/"))) {
                String operator = list.pollLast();
                Integer op1 = Integer.valueOf(list.pollLast());
                Integer op2 = Integer.valueOf(exprTokens[i]);
                if(operator.equals("*")) {
                    list.add(String.valueOf(op1 * op2));
                } else {
                    list.add(String.valueOf(op1 / op2));
                }
            }
            else {
                list.add(exprTokens[i]);
            }
        }
        return list;
    }

    public boolean isValidExpression(String expression) {
        return expression.matches("\\d+(\\s[\\+|\\-|\\*|\\/]\\s\\d+)*");
    }
}
