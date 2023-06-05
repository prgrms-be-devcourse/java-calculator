import View.InputView;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> arithmeticRecords = new ArrayList<>();

        while (true) {
            System.out.println("1.계산");
            System.out.println("2.조회");
            int select = InputView.selectWorks();
            //예외처리
            if(select == -1){
                break;
            }
            //연산 시작
            else if (select == 1) {
                String[] infixExpression = InputView.inputExpression();
                String postfixExpression = Calculator.toPostfix(infixExpression);
                System.out.println(postfixExpression);
                // 연산결과 저장
//                arithmeticRecords.add(infixExpression + " = " + result);
            }
            // 조회 시작
            else{
                System.out.println(1);
            }
        }
    }

}
