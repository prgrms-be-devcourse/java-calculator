package com.calculator.java.domain.comand;


import com.calculator.java.domain.database.Database;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Calculation implements Command {
    private String mathExpression;
    private Database database;

    public Calculation(Database database) {
        this.database = database;
    }

    public void setMathExpression(String mathExpression) {
        this.mathExpression = mathExpression;
    }

    @Override
    public String doCommand() {
        StringTokenizer st = new StringTokenizer(mathExpression);
        int numOfElements = st.countTokens();
        List<String> elements = new ArrayList<>();

        for (int i = 0; i < numOfElements; i++) {
            String element = st.nextToken();

            if (i % 2 == 0) {
                int lastIndex = elements.size() - 1;

                if (i > 0 && (elements.get(lastIndex).equals("*") || elements.get(lastIndex).equals("/"))) {
                    String operator = elements.remove(lastIndex);
                    int num1 = Integer.parseInt(elements.remove(lastIndex - 1));
                    int num2 = Integer.parseInt(element);

                    if(operator.equals("/") && num2 == 0) {
                        return "계산할 수 없습니다.";
                    }

                    element = Integer.toString(calculate(num1, num2, operator));
                }

                elements.add(element);
            } else {
                elements.add(element);
            }
        }

        numOfElements = elements.size();
        int result = Integer.parseInt(elements.get(0));

        for (int i = 2; i < numOfElements; i += 2) {
            if (i % 2 == 0) {
                int num = Integer.parseInt(elements.get(i));
                String operator = elements.get(i - 1);
                result = calculate(result, num, operator);
            }
        }

        saveResult(mathExpression, result);

        return Integer.toString(result);
    }

    private int calculate(int num1, int num2, String operate) {
        switch (operate) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            default:
                return num1 / num2;
        }
    }

    private void saveResult(String mathExpression, int result) {
        database.add(mathExpression + " = " + result);
    }
}
