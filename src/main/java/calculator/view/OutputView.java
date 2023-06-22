package calculator.view;

import calculator.domain.Expression;

import java.util.Map;

public class OutputView {
    private static final String COMMAND_MESSAGE = "1. 조회 \n2. 계산 \n3. 종료 \n\n선택 : ";
    private static final String NO_HISTORY = "이력이 존재하지 않습니다.\n";

    public void printCommand() {
        System.out.print(COMMAND_MESSAGE);
    }

    public void printHistory(Map<Expression, Integer> history) {
        if (history.isEmpty()) {
            System.out.println(NO_HISTORY);
            return;
        }

        history.entrySet().forEach(h -> System.out.println(h.getKey()+ " = " + h.getValue()));
        System.out.println();
    }

    public void printResult(int result) {
        System.out.println(result + "\n");
    }
}
