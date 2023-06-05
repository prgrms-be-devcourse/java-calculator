package view;


import model.CalculationLog;

import java.util.Map;

public class OutputView {
    public enum Menu {
        CHECK("1. 조회"),
        CALCULATE("2. 계산"),
        END("3. 종료");

        private final String description;

        Menu(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    private static final String INPUT = "선택 : ";
    private static final String END = "프로그램을 종료합니다.";

    public static void printSelectMenu() {
        System.out.println(Menu.CHECK.getDescription());
        System.out.println(Menu.CALCULATE.getDescription());
        System.out.println(Menu.END.getDescription());
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
