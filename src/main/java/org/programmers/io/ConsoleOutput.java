package org.programmers.io;

import org.programmers.domain.expression.ExpressionResult;

import java.util.Map;

public class ConsoleOutput implements Output {

    public void printConsole() {
        System.out.println("1. 조회");
        System.out.println("2. 계산");
        System.out.println("3. 종료");
        System.out.print("선택 : ");
    }

    @Override
    public void printAnswer(double answer) {
        System.out.println(answer + "\n");
    }

    @Override
    public void printError() {
        System.out.println("올바르지 않은 메뉴 번호가 입력되었습니다.");
    }


    @Override
    public void printHistory(Map<Long, ExpressionResult> history) {
        for (long i = history.size() - 1; i >= 0; i--) {
            System.out.println(history.get(i).toString());
        }
        System.out.println();
    }
}
