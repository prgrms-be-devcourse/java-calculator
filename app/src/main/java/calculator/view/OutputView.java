package calculator.view;

import calculator.entity.Menu;

public final class OutputView {

    private static final String MENU_INPUT_MESSAGE = "메뉴를 입력해주세요(숫자만 입력) : ";
    private static final String EXPRESSION_INPUT_MESSAGE = "계산식을 입력하세요(자연수, 사칙연산, 공백 기준) : ";
    private static final String QUIT_MESSAGE = "프로그램을 종료합니다.";
    private static final String CALCULATION_RESULT_MESSAGE = "계산 결과 : ";
    private static final String EMPTY_HISTORY_MESSAGE = "계산 내역이 존재하지 않습니다.";
    private static final int EMPTY_LENGTH = 0;

    private OutputView() {
    }

    public static void showMenu() {
        printMultiple(Menu.values());
        printWithLineBreak();
        printWithoutLineBreak(MENU_INPUT_MESSAGE);
    }

    public static void showExpressionInputMessage() {
        printWithLineBreak();
        printWithoutLineBreak(EXPRESSION_INPUT_MESSAGE);
    }

    public static void showQuitMessage() {
        printWithLineBreak();
        printWithLineBreak(QUIT_MESSAGE);
    }

    public static void showCalculationResult(int calculationResult) {
        printWithLineBreak(CALCULATION_RESULT_MESSAGE + calculationResult);
        printWithLineBreak();
    }

    public static void showAllHistory(String[] allHistory) {
        if (allHistory.length == EMPTY_LENGTH) {
            printWithLineBreak(EMPTY_HISTORY_MESSAGE);
            printWithLineBreak();

            return;
        }

        printMultiple(allHistory);
        printWithLineBreak();
    }

    public static void printWithLineBreak() {
        System.out.println();
    }

    public static void printWithLineBreak(String output) {
        System.out.println(output);
    }

    public static void printWithoutLineBreak(String output) {
        System.out.print(output);
    }

    public static <T> void printMultiple(T[] outputs) {
        for (T output : outputs) {
            System.out.println(output);
        }
    }
}
