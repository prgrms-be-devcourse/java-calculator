package model;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Double.parseDouble;

public class Calculator {
    public static double calculate(String expression) {
        List<String> exprResults = new ArrayList<>();
        Operator operator = new Operator();
        String[] splitExpressions = expression.split(" ");
        multiplyAndDivide(splitExpressions, operator, exprResults);
        return plusAndMinus(splitExpressions, operator, exprResults);
    }

    /**
     * exprResults 리스트에 곱셈, 나눗셈이 수행된 연산자, 피연산자를 저장합니다.
     * 예를 들어, 10 + 1 * 9 - 10 / 2 가 입력되었다면
     * 리스트에는 ["10", "+", "9", "-", "5"]가 저장됩니다.
     */
    private static void multiplyAndDivide(String[] splitExpr, Operator operator, List<String> exprResults) {
        for(int i = 0; i< splitExpr.length; i++){
            if(splitExpr[i].equals("*") || splitExpr[i].equals("/")){
                String op = splitExpr[i];
                int lastIndex = exprResults.size()-1;
                double firstNum = parseDouble(exprResults.get(lastIndex));
                double secondNum = parseDouble(splitExpr[i + 1]);
                double resultNum = operator.operate(firstNum, secondNum, op);
                exprResults.remove(lastIndex);
                exprResults.add(String.valueOf(resultNum));
                i++;
            } else {
                exprResults.add(splitExpr[i]);
            }
        }
    }

    /**
     * 연산자를 기준으로 덧셈, 뺄셈 계산을 수행합니다.
     * 수행된 결과는 Expression 객체에 결과값 필드인 calcResult를 set해 넣어줍니다.
     */
    private static double plusAndMinus(String[] splitExpr, Operator operator, List<String> exprResults) {
        double resultNum = parseDouble(exprResults.get(0));
        for(int i = 1; i< exprResults.size(); i+=2){
            String op = exprResults.get(i);
            double secondNum = parseDouble(exprResults.get(i+1));
            resultNum = operator.operate(resultNum, secondNum, op);
        }
        return resultNum;
    }
}
