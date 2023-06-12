package calculator.view;

import calculator.entity.Menu;

public final class OutputView {

    private static final String MENU_INPUT_MESSAGE = "메뉴를 입력해주세요(숫자만 입력) : ";
    private static final String EXPRESSION_INPUT_MESSAGE = "계산식을 입력하세요(자연수, 사칙연산, 공백 기준) : ";
    private static final String QUIT_MESSAGE = "프로그램을 종료합니다.";

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
        printWithLineBreak(QUIT_MESSAGE);
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
