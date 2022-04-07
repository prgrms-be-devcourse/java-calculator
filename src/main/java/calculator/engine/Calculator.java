package calculator.engine;

import calculator.engine.io.Input;
import calculator.engine.io.Output;
import calculator.engine.model.HistoryDatabase;
import calculator.engine.model.PostfixCalculator;
import calculator.engine.model.PostfixConverter;
import lombok.AllArgsConstructor;

import java.util.ArrayList;

@AllArgsConstructor
public class Calculator implements Runnable {
    private final Input input;
    private final Output output;
    private final HistoryDatabase database;

    @Override
    public void run() {

        while (true) {
            String selectedMenu = input.input("\n1. 조회\n2. 계산\n(1, 2 이외의 문자를 입력하면 종료됩니다.)\n\n\n선택 :");

            if (selectedMenu.equals("1") || selectedMenu.equals("조회")) {
                output.calcHistory(database.getHistories());
            } else if (selectedMenu.equals("2") || selectedMenu.equals("계산")) {
                // 입력받음
                String arith = input.input("계산식을 입력해주세요: ");

                // 계산
                String[] infix = Input.parse(arith);
                ArrayList<String> postfix = PostfixConverter.convertToPostfix(infix);
                System.out.println(postfix);
                Double result = PostfixCalculator.getResult(postfix);

                // 계산 결과 저장
                database.addHistory(arith, result);

                // 계산 결과 출력
                output.calcResult(result);
            } else {
                break;
            }
        }
    }
}
