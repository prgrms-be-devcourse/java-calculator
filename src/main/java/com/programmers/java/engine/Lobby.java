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
    private final String validExpRegex="\\d+(\\.\\d+)*( [\\+\\-\\*\\/] \\d+(\\.\\d+)*)*";
    /* run : 실행로직을 가지고 있는 메소드 */
    @Override
    public void run() {
        StringBuilder menus = new StringBuilder();
        for (Menu m : Menu.values()) {
            menus.append(m.ordinal()).append(".").append(m).append("\n");
        }

        final int EXIT = Menu.EXIT.ordinal();
        final int LOOKUP = Menu.LOOKUP.ordinal();
        final int CALCULATE = Menu.CALCULATE.ordinal();

        while (true) {
            try {
                System.out.println('\n' + menus.toString());

                int userOption = input.optionInput("선택 : ");
                if (userOption == EXIT) {
                    output.exitMessage();
                    break;
                } else if (userOption == LOOKUP) {
                    history.searchAll();
                } else if (userOption == CALCULATE) {
                    output.informFormat();
                    String userStr = input.strInput("계산식을 입력해주세요 : ");
                    String[] parsedUserStr = parse(userStr, validExpRegex);
                    String ans = calculator.calculate(parsedUserStr);
                    System.out.println(ans);
                    history.save(new Expression(userStr, ans));
                } else {
                    output.inputError();
                }
            } catch (Exception e) {
                output.errorMessage(e);
            }
        }

    }

    /*
     * parse : 사용자가 입력한 문자열에 대해 파싱을 하는 함수
     * - 길이 검사
     * - 공백 기준으로 split 후, 각 문자가 연산자인지, 피연산자인지 검사
     * - 정상적이면 String[]을 반환하고, 아니라면 ParsedException을 throw한다.
     * */
    public String[] parse(String userStr, String regex) throws Exception {

        if (!Pattern.matches(regex, userStr)) throw new ParsedException();
        return userStr.split(" ");
    }
}
