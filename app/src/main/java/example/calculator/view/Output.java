package example.calculator.view;

import example.calculator.model.Menu;
import java.util.List;

public class Output {
    public void printCalculationHistory(List<String> calculationHistory) {
        for (String history : calculationHistory) {
            System.out.println(history);
        }
    }

    public void printMenu() {
        System.out.println(Menu.조회.getFormattedInfo());
        System.out.println(Menu.계산.getFormattedInfo());
    }

    public void printResult(double result) {
        System.out.println("결과: " + result);
    }

    public void printMessage() {
        System.out.print("수식을 입력하세요: ");
    }
}
