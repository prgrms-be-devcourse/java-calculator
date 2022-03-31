package calculator.view;

import java.util.List;
import java.util.Scanner;

public class Console implements OutputView, InputView {
    private static final String REQUEST_INSERT_MENU = "1. 조회\n2. 계산\n3. 종료\n\n선택 : ";

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String inputMenu() {
        System.out.print(REQUEST_INSERT_MENU);
        return scanner.nextLine().trim();
    }

    @Override
    public String inputExpression() {
        System.out.println();
        return scanner.nextLine();
    }

    @Override
    public void printResult(String result) {
        System.out.println(result + "\n");
    }

    @Override
    public void printResults(List<String> results) {

        if (results.isEmpty()) {
            System.out.println("계산 결과가 없습니다.\n");
            return;
        }

        System.out.println();
        results.forEach(System.out::println);
        System.out.println();
    }
    
    @Override
    public void printWrongCommandError() {
        System.out.println("\n[ERROR] 1, 2, 3번 중 선택하세요.\n");
    }

    @Override
    public void printErrorMsg(String msg) {
        System.out.println(msg);
    }
}
