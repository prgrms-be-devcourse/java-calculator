package calculator.calculate;

import calculator.console.Console;
import calculator.repository.ResultRepository;

import java.io.IOException;
import java.util.*;

public class CalculatorImpl implements Calculator {

    private final Console console;
    private final ResultRepository repository;

    public CalculatorImpl(Console console, ResultRepository repository) {
        this.console = console;
        this.repository = repository;
    }

    public void run() throws IOException {
        while(true) {
            String expression = console.input();

            if(!isValidExpression(expression)) {
                console.print("유효하지 않은 식입니다.");
            }
            else {
                Integer result;
                if(repository.isCalculated(expression)) result = repository.getResult(expression);
                else result = calculate(expression);
                console.print(String.valueOf(result));
            }
        }
    }

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

    public Boolean isValidExpression(String expr) {
        return expr.matches("\\d+(\\s[\\+|\\-|\\*|\\/]\\s\\d+)*");
    }
}
