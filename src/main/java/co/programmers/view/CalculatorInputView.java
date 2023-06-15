package co.programmers.view;

import co.programmers.domain.Expression;
import java.util.Scanner;

public class CalculatorInputView implements InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public Integer inputUserMenu() {
        CalculatorOutputView.printMenuChoiceGuide();
        Integer userInput = SCANNER.nextInt();
        SCANNER.nextLine();
        return userInput;
    }

    public Expression inputExpression() throws ArithmeticException {
        CalculatorOutputView.printCalculationGuide();
        return new Expression(SCANNER.nextLine());
    }
}
