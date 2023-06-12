package calculator.view;

public class OutputView {
    private static final String COMMAND_MESSAGE = "1. 조회 \n2. 계산 \n3. 종료 \n\n선택 : ";

    public void printCommand() {
        System.out.print(COMMAND_MESSAGE);
    }

    public void printResult(int result) {
        System.out.println(result + "\n");
    }
}
