package com.programmers.java.engine;

import com.programmers.java.engine.io.Input;
import com.programmers.java.engine.io.Output;
import com.programmers.java.engine.io.exception.*;
import com.programmers.java.engine.model.Calculator;
import com.programmers.java.engine.model.Expression;
import com.programmers.java.engine.model.History;
import com.programmers.java.engine.model.Operator;

import lombok.AllArgsConstructor;

import java.util.Optional;
import java.util.regex.Pattern;

import static com.programmers.java.engine.Menu.*;

/*
 * Lobby : 로비
 * - 사용자가 로비에서 메뉴를 선택하고 결과를 확인한다.
 * - 고민 : output에 대한 깔끔한 관리의 어려움 / 어떤 것은 System.out. 어떤 것은 output..
 * - output으로 관리하는 문자열들에 대한 기준이 모호함
 * */
@AllArgsConstructor
public class Lobby implements Runnable {

    private Input input;
    private Output output;
    private History history;
    private Calculator calculator;

    /* run : 실행로직을 가지고 있는 메소드 */
    @Override
    public void run() {
        StringBuilder menus = new StringBuilder();
        for (Menu m : Menu.values()) {
            menus.append(m.ordinal()).append(".").append(m).append("\n");
        }

        while (true) {
            try {
                System.out.println('\n' + menus.toString());
                Menu userOption = input.optionInput("선택 : ");
                switch (userOption) {
                    case EXIT:
                        output.exitMessage();
                        break;
                    case LOOKUP:
                        System.out.println(history.searchAll());
                        continue;
                    case CALCULATE:
                        output.informFormat();
                        String userStr = input.expressionInput("계산식을 입력해주세요 : ");
                        String ans = calculator.calculate(userStr.split(" "));
                        System.out.println(ans);
                        history.save(new Expression(userStr, ans));
                        continue;
                    default:
                        continue;
                }
                break;
            } catch (Exception e) {
                output.errorMessage(e);
            }
        }

    }
}
