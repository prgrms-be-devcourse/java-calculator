package com.calculator.java.comand;


import com.calculator.java.database.Database;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Calculation implements Command {
    private final String IMPOSSIBLE = "계산할 수 없습니다.";

    private String mathExpression;

    private final Database database;

    public Calculation(Database database) {
        this.database = database;
    }

    public void setMathExpression(String mathExpression) {
        this.mathExpression = mathExpression;
    }

    @Override
    public String doCommand() {
        List<String> elements = new ArrayList<>();

        if(!multiplyAndDivide(elements)) {
            return IMPOSSIBLE;
        }else{
            int result = plusAndMinus(elements);
            saveResult(mathExpression, result);

            return Integer.toString(result);
        }
    }

    private boolean multiplyAndDivide(List<String> elements) {
        StringTokenizer st = new StringTokenizer(mathExpression);
        int numOfElements = st.countTokens();

        for (int i = 0; i < numOfElements; i++) {
            String element = st.nextToken();

            if (i % 2 == 0) {
                int indexOfLastElement = elements.size() - 1;
                if (i > 0 && (elements.get(indexOfLastElement).equals("*") || elements.get(indexOfLastElement).equals("/"))) {
                    String operator = elements.remove(indexOfLastElement);
                    int num1 = Integer.parseInt(elements.remove(indexOfLastElement - 1));
                    int num2 = Integer.parseInt(element);

                    if(operator.equals("/") && num2 == 0) return false;

                    element = Integer.toString(calculate(num1, num2, operator));
                }
            }

            elements.add(element);
        }

        return true;
    }

    private int plusAndMinus(List<String> elements) {
        int numOfElements = elements.size();
        int result = Integer.parseInt(elements.get(0));

        for (int i = 2; i < numOfElements; i += 2) {
            int num = Integer.parseInt(elements.get(i));
            String operator = elements.get(i - 1);
            result = calculate(result, num, operator);
        }

        return result;
    }

    private int calculate(int num1, int num2, String operate) {
        return switch (operate) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            default -> num1 / num2;
        };
    }

    private void saveResult(String mathExpression, int result) {
        database.add(mathExpression + " = " + result);
    }
}
