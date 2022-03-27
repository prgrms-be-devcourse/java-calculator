package com.programmers.oop;

import java.io.IOException;

import com.programmers.oop.message.FrontMessage;
import com.programmers.oop.view.Console;
import com.programmers.oop.view.Input;
import com.programmers.oop.view.Output;

public class CalculatorMachine {

    private final Input input;
    private final Output output;

    public CalculatorMachine(Console console) {
        input = console;
        output = console;
    }

    public void start() throws IOException {
        output.showMessage(FrontMessage.MENU_LIST.getMessage());
        String menu = input.readInput();

        if (menu.equals("1")) {
            /**
             * todo : 저장소에서 계산 이력 결과 보여주기
             *   - 이력이 하나도 존재하지 않는다면 '없음'을 의미하는 메시지 출력하기
             */
        } else if (menu.equals("2")) {
            /**
             * todo : 계산식 입력 유효성 검증.
             *  - 숫자와 '+', '-' , '*', '/' 이루어 져있는지
             *  - 결과 : 예외 발생 !
             * bug : 입력값 타입 설정 및 계산 오버플로우 주의!
             */
            output.showMessage(FrontMessage.FORMULA.getMessage());
            String formula = input.readInput();
        } else {
            throw new RuntimeException("status : 4xx, client error");
        }


    }

}
