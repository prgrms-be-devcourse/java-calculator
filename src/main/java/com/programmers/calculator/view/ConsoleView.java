package com.programmers.calculator.view;

import com.programmers.calculator.controller.ConsoleController;
import com.programmers.calculator.controller.io.ConsoleRequest;
import com.programmers.calculator.controller.io.ConsoleResponse;
import java.util.Map;
import java.util.Scanner;

public class ConsoleView implements View {

    private final Scanner scanner;

    private final Map<Command, Runnable> mapping;

    public ConsoleView(ConsoleController controller, Scanner console) {
        this.scanner = console;
        mapping = Map.of(
                Command.INQUIRY,
                () -> write(controller.inquiry()),
                Command.CALCULATION,
                () -> {
                    ConsoleRequest request = read();
                    write(controller.calculate(request));
                },
                Command.EXIT, () -> {
                    throw new RuntimeException("프로그램을 종료합니다.");
                }
        );
    }

    @Override
    public void show() {
        System.out.println("0. 종료");
        System.out.println("1. 조회");
        System.out.println("2. 계산");

        String selectedInput = read().getExpression();
        validateSelected(selectedInput);

        System.out.println("선택 : " + selectedInput);

        Command command = Command.of(selectedInput);

        mapping.get(command).run();
    }

    @Override
    public ConsoleRequest read() {
        String input = scanner.nextLine();
        return new ConsoleRequest(input);
    }

    @Override
    public void write(ConsoleResponse response) {
        System.out.println(response.result());
        System.out.println();
    }

    private void validateSelected(String select) {
        int selectNumber = Integer.parseInt(select);

        if (!Command.canCreate(selectNumber)) {
            throw new IllegalArgumentException("입력값이 잘못되었습니다.");
        }
    }

}
