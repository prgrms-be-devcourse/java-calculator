package calculator.io;

import java.util.List;
import java.util.Scanner;

public class IOManager implements Input, Output {

    private static final String FIND_ALL_ORDER_MESSAGE = "1. 조회";
    private static final String CALCULATE_ORDER_MESSAGE = "2. 계산";
    private static final String EXIT_ORDER_MESSAGE = "3. 종료";
    private static final String CHOICE_MESSAGE = "선택 : ";
    private static final String EXIT_MESSAGE = "종료!";
    private static final String FORMULA_MESSAGE = "수식을 입력해 주세요 : ";
    private static final String WRONG_ORDER_MESSAGE = "없는 명령 입니다!";
    private static final String DIVIDE_ZERO_MESSAGE = "0으로 나눌 수 없어요!";
    private static final String NO_DATA_MESSAGE = "실행된 계산이 없어요!";
    private static final String WRONG_FORMULA_MESSAGE = "잘못된 수식입니다!";
    private static final Scanner sc = new Scanner(System.in);

    @Override
    public String inputOrder() {
        return sc.nextLine();
    }

    @Override
    public String inputFormula() {
        System.out.print(FORMULA_MESSAGE);
        return sc.nextLine();
    }

    @Override
    public void requestInput() {
        System.out.println(FIND_ALL_ORDER_MESSAGE);
        System.out.println(CALCULATE_ORDER_MESSAGE);
        System.out.println(EXIT_ORDER_MESSAGE);
        System.out.println();
        System.out.print(CHOICE_MESSAGE);
    }

    @Override
    public void printAnswer(String result) {
        System.out.println(result);
        System.out.println();
    }

    @Override
    public void printFormulas(List<String> list) {
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println();
    }

    @Override
    public void printExit() {
        System.out.println(EXIT_MESSAGE);
    }

    @Override
    public void printWrongOrder() {
        System.out.println(WRONG_ORDER_MESSAGE);
    }

    @Override
    public void printDivideZero() {
        System.out.println(DIVIDE_ZERO_MESSAGE);
    }

    @Override
    public void printNoData() {
        System.out.println(NO_DATA_MESSAGE);
    }

    @Override
    public void printWrongFormula() {
        System.out.println(WRONG_FORMULA_MESSAGE);
    }
}
