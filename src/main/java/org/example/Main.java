package org.example;

import org.example.View.InputView;
import org.example.View.OutputView;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> arithmeticRecords = new ArrayList<>();

        while (true) {
            System.out.println("1.조회");
            System.out.println("2.계산");
            int select = InputView.selectWorks();
            // 종료하고 싶은 경우
            if (select == -1) {
                break;
            }
            //연산
            else if (select == 2) {
                String infixExpression = InputView.inputExpression();
                double result = Calculator.calculate(infixExpression);
                OutputView.printResult(result);
                // 연산결과 저장
                arithmeticRecords.add(infixExpression.toString() + " = " + result);
            }
            // 조회
            else {
                OutputView.printRecords(arithmeticRecords);
            }
        }
    }

}
