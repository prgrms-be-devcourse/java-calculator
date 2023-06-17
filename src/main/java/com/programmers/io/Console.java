package com.programmers.io;

import com.programmers.domain.CalculatorRepository;
import com.programmers.domain.Expression;
import com.programmers.domain.Menu;

import java.util.List;
import java.util.Scanner;

public class Console implements Output, Input {

    private static final String MENU_MESSAGE = "1. 조회\n2. 계산\n3. 종료\n";
    private static final String MENU_SELECTION_MESSAGE = "선택 : ";
    private static final String TERMINATION_MESSAGE = "계산기 프로그램을 종료합니다.";

    private final Scanner scanner = new Scanner(System.in);
    private final CalculatorRepository calculatorRepository = new CalculatorRepository();

    @Override
    public void printMenu() {
        System.out.println(MENU_MESSAGE);
        System.out.print(MENU_SELECTION_MESSAGE);
    }

    @Override
    public String readInput() {
        return scanner.nextLine();
    }

    public String getSelection() {
        printMenu();
        return readInput();
    }

    public String getExpressionSpaceRemoved() {
        System.out.print("\n");
        String expression = readInput();
        return removeSpace(expression);
    }

    public String removeSpace(String input) {
        return input.trim().replace(" ", "");
    }

    @Override
    public void printTermination() {
        System.out.println("\n" + TERMINATION_MESSAGE);
    }

    public Menu getValidatedMenuSelection() {
        String selection = getSelection();

        try {
            return Menu.findMenu(selection);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getValidatedMenuSelection();
        }
    }

    public List<String> getValidatedExpression() {
        String input = getExpressionSpaceRemoved();

        try {
            Expression expression = new Expression(input);
            return expression.getValidatedTokens();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getValidatedExpression();
        }
    }

    public void printResult(int result) {
        System.out.println(result + "\n");
    }

    public void getResults() {
        System.out.println();
        List<String> all = calculatorRepository.findAll();
        all.forEach(System.out::println);
        System.out.println();
    }
}
