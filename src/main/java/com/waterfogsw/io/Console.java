package com.waterfogsw.io;

import com.waterfogsw.domain.Calculation;
import com.waterfogsw.exception.InvalidFormulaInput;
import com.waterfogsw.exception.InvalidMenuInput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Console implements Input, Output {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public int inputMenu(String prompt) throws IOException, InvalidMenuInput {
        System.out.print(prompt);
        String input = br.readLine();

        System.out.println();
        if (!isValidMenu(input)) {
            throw new InvalidMenuInput();
        } else {
            return Integer.parseInt(input);
        }
    }

    @Override
    public String inputFormula(String prompt) throws IOException, InvalidFormulaInput {
        System.out.print(prompt);
        String input = br.readLine();
        System.out.println();
        if (isValidFormula(input)) {
            return input;
        } else {
            throw new InvalidFormulaInput();
        }
    }

    @Override
    public void printResult(String expr, String result) {
        System.out.println(expr + " = " + result);
        System.out.println();
    }

    @Override
    public void printHistories(List<Calculation> calculations) {
        calculations.forEach(System.out::println);
        System.out.println();
    }

    @Override
    public void inputError() {
        System.out.println(ErrorMessage.WRONG_INPUT);
    }

    @Override
    public void divZeroError() {
        System.out.println(ErrorMessage.DIV_BY_ZERO);
    }

    @Override
    public void dataOverflowError() {
        System.out.println(ErrorMessage.DATA_OVERFLOW);
    }

    private boolean isValidMenu(String menu) {
        Pattern pattern = Pattern.compile(ValidationRegex.MENU_REGEX);
        Matcher matcher = pattern.matcher(menu);
        return !matcher.find();
    }

    private boolean isValidFormula(String formula) {
        return formula.matches(ValidationRegex.FORMULA_REGEX);
    }

}
