package view;


import model.CalculationLog;

import java.util.Arrays;
import java.util.Map;

public class OutputView {
    public enum Menu {
        LOAD(1, "1. 조회"),
        CALCULATE(2, "2. 계산"),
        END(3, "3. 종료");

        private final int menuNumber;
        private final String description;

        Menu(int menuNumber, String description) {
            this.menuNumber = menuNumber;
            this.description = description;
        }

        public boolean isExistMenu(int userInput) {
            return this.menuNumber == userInput;
        }

        public int getMenuNumber() {
            return menuNumber;
        }

        public String getDescription() {
            return description;
        }
    }

    private static final String INPUT = "선택 : ";
    private static final String END = "프로그램을 종료합니다.";

    public static void printSelectMenu() {
        Arrays.stream(Menu.values()).forEach(m -> System.out.println(m.getDescription()));
        System.out.println();
        System.out.print(INPUT);
    }

    public static void printResult(final int result) {
        System.out.println(result);
        System.out.println();
    }

    public static void printLogs(final Map<Long, CalculationLog> repository) {
        for (Long key : repository.keySet()) {
            System.out.println(repository.get(key));
        }
        System.out.println();
    }

    public static void printTurnOff() {
        System.out.println(END);
    }

    public static void printErrorMessage(final String em) {
        System.out.println(em);
    }
}
