package org.calculator.engine.io;

import org.calculator.engine.error.ErrorCode;

import java.util.Optional;
import java.util.Scanner;

public class ConsoleImpl implements Console {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void printAnswer(int answer) {
        System.out.println(answer);
    }

    @Override
    public void printError(ErrorCode errorCode) {
        ErrorCode.printError(errorCode);
    }

    @Override
    public Optional<String> getCondition() {
        System.out.println("1. 조회");
        System.out.println("2. 계산");
        System.out.println("3. 종료");
        System.out.println();
        System.out.print("선택 : ");
        return Optional.of(scanner.nextLine());
    }

    @Override
    public String insertEquation() {
        System.out.println();
        System.out.print("방정식을 입력해 주세요 : ");
        return scanner.nextLine();
    }
}
