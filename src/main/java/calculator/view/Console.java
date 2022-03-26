package calculator.view;

import java.util.List;
import java.util.Scanner;

public class Console implements OutputView, InputView {
    private static final String REQUEST_INSERT_MENU = "1. 조회\n2. 계산\n3. 종료\n\n선택 : ";

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String inputMenu() {
        System.out.print(REQUEST_INSERT_MENU);
        return scanner.nextLine();
    }

    @Override
    public String inputExpression() {
        System.out.println();
        return scanner.nextLine();
    }

    @Override
    public void printResults(List<String> results) {
        results.forEach(System.out::println);
    }

    @Override
    public void printNoResults() {
        System.out.println("연산 결과가 없습니다.\n");
    }
}
