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
    public String doCommand()  {
        // 주의 : 1 / 0 => return "연산 불가능"

        StringTokenizer st = new StringTokenizer(mathExpression);
        int numOfElements = st.countTokens();
        List<String> elements = new ArrayList<>();

        for(int i = 0; i < numOfElements; i++) {
            String element = st.nextToken();

            if(i % 2 == 0) {
                // 숫자
                elements.add(element);
            }else{
                elements.add(element);
            }
        }

        int result = Integer.parseInt(elements.get(0));
        for(int i = 2; i < numOfElements; i+=2) {
            if(i % 2 == 0) {
                int num = Integer.parseInt(elements.get(i));
                String operator = elements.get(i-1);
                result = calculate(result, num, operator);
            }
        }

        // 연산 결과를 저장
        saveResult(elements, result);

        return Integer.toString(result);
    }

    private int calculate(int num1, int num2, String operate) {
        switch (operate) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            default:
                return 0;
        }
    }

    private void saveResult(List<String> elements, int result) {
        String mathExpression = String.join(" ", elements);
        database.add(mathExpression+" = "+result);
    }
}
