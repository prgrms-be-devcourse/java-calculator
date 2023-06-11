package co.programmers.view;

import co.programmers.exception.ExceptionMessage;
import co.programmers.domain.UserMenu;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class CalculatorInputView implements InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Set<String> USER_MENU =
            Arrays.stream(UserMenu.values())
                    .map(UserMenu::getValue)
                    .collect(Collectors.toSet());

    public CalculatorInputView() {
    }

    public String inputUserMenu() {
        printMenuChoiceGuide();
        String userInput = SCANNER.next();
        SCANNER.nextLine();
        try {
            validateUserMenuChoice(String.valueOf(userInput));
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return UserMenu.TERMINATE.getValue();
        }
        return userInput;
    }

    public String inputExpression() {
        printCalculationGuide();
        String expression = SCANNER.nextLine();
        return expression;
    }

    private void printCalculationGuide() {
        System.out.println("1 + 2 * 3와 같은 형식으로 계산하고자 하는 식을 입력하세요.");
        System.out.print("> ");
    }

    private void printMenuChoiceGuide() {
        System.out.println("\n[다음 중 원하시는 항목을 숫자로 입력하세요]");
        System.out.println("1. 조회");
        System.out.println("2. 계산");
        System.out.println("3. 종료");
        System.out.print("> 선택 :  ");
    }

    private void validateUserMenuChoice(String userInput) throws IllegalArgumentException {
        if (!USER_MENU.contains(userInput)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT);
        }
    }
}