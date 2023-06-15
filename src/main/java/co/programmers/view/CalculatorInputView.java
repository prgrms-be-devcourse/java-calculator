package co.programmers.view;

import co.programmers.domain.Expression;
import java.util.Scanner;

public class CalculatorInputView implements InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public Integer inputUserMenu() {
        Integer userInput = SCANNER.nextInt();
        SCANNER.nextLine();
        return userInput;
    }

    public Expression inputExpression() throws ArithmeticException {
        return new Expression(SCANNER.nextLine());
    }
}
