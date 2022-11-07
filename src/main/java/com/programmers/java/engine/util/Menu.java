package com.programmers.java.engine.util;

import com.programmers.java.engine.CalculatorController;
import com.programmers.java.engine.exception.MenuException;
import com.programmers.java.engine.model.Expression;

import java.util.Arrays;

public enum Menu {
    LOOKUP("1") {
        @Override
        public void run(CalculatorController controller) {
            if (controller.getHistoryRepository().size() == 0) {
                controller.getIoController().print("저장된 내역이 없습니다.\n");
            }

            controller.getHistoryRepository().load().stream()
                    .forEach(expression -> controller.getIoController().print(expression + "\n"));
        }
    },
    COMPUTE("2") {
        @Override
        public void run(CalculatorController controller) {
            Expression expression = new Expression(controller.getIoController().read());
            Number result = controller.getCalculator().calculate(controller.getTranslator().translate(expression));
            controller.getIoController().print(result + "\n");
            expression.add(" = " + result);
            controller.getHistoryRepository().save(expression);
        }
    },
    EXIT("3") {
        @Override
        public void run(CalculatorController controller) {
            controller.getIoController().print("프로그램이 종료됩니다...\n");
            controller.setExit(true);
        }
    },
    GUIDE("\n1. 조회\n2. 계산\n3. 종료\n\n선택 : ") {
        @Override
        public void run(CalculatorController controller) {
            controller.getIoController().print(this.get());
        }
    };

    private final String select;

    Menu(String select) {
        this.select = select;
    }

    public static Menu findMenu(String command) {
        return Arrays.stream(Menu.values())
                .filter(menu -> menu.select.equals(command))
                .findAny()
                .orElseThrow(() -> new MenuException("올바른 메뉴를 선택해주세요.\n"));
    }

    public String get() {
        return this.select;
    }

    public abstract void run(CalculatorController controller);
}
