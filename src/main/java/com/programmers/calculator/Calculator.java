package com.programmers.calculator;

import com.programmers.calculator.exception.validation.FormulaValidationException;
import com.programmers.calculator.exception.io.NumberInputException;
import com.programmers.calculator.exception.validation.ValidationException;
import com.programmers.calculator.repository.Repository;
import com.programmers.calculator.util.Parser;
import com.programmers.calculator.util.io.Input;
import com.programmers.calculator.util.io.Output;
import com.programmers.calculator.validator.FormulaValidator;
import com.programmers.calculator.validator.Validator;
import com.programmers.calculator.vo.Formula;

import java.util.*;

public class Calculator implements Runnable {
    private final Repository<Formula> repository;
    private final Input input;
    private final Output<Formula> output;
    private final Validator<String> validator;
    private final Parser parser;

    private final String newline = System.getProperty("line.separator");
    private final String MENU_INPUT_SCRIPT = "1. 조회" + newline + "2. 계산" + newline + "3. 종료" + newline + newline + "선택 : ";
    private final String FORMULA_INPUT_SCRIPT = "식 입력 : ";

    public Calculator(Input input, Output<Formula> output, Repository<Formula> repository) {
        this.repository = repository;
        this.input = input;
        this.output = output;
        this.validator = FormulaValidator.getInstance();
        this.parser = Parser.getInstance();
    }

    @Override
    public void run() {
        boolean flag = true;
        while (flag) {
            try {
                switch (input.inputNumber(MENU_INPUT_SCRIPT)) {
                    case 1:
                        output.outputList(repository.findAll());
                        break;
                    case 2:
                        String originFormula = input.inputString(FORMULA_INPUT_SCRIPT);
                        validator.validate(originFormula);
                        String[] formula = parser.parse(originFormula);
                        Formula result = repository.save(new Formula(formula, calculate(formula)));
                        System.out.println(result.getResult() + newline);
                        break;
                    case 3:
                        flag = false;
                        break;
                    default:
                        throw new NumberInputException();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage() + newline);
            }
        }
    }

    private String calculate(String[] originFormula) throws ValidationException {
        String[] formula = parser.getPostfix(originFormula);
        Stack<String> calculatorStack = new Stack<>();
        Set<String> operationCode = new HashSet<>(Arrays.asList("+", "-", "*", "/"));

        try {
            for (String token : formula) {
                if (operationCode.contains(token)) {
                    Double b = Double.parseDouble(calculatorStack.pop());
                    Double a = Double.parseDouble(calculatorStack.pop());
                    Double result;
                    switch (token) {
                        case "+":
                            result = a + b;
                            break;
                        case "-":
                            result = a - b;
                            break;
                        case "*":
                            result = a * b;
                            break;
                        case "/":
                            result = a / b;
                            break;
                        default:
                            throw new FormulaValidationException();
                    }
                    calculatorStack.add(String.valueOf(result));
                } else {
                    calculatorStack.add(token);
                }
            }
            return calculatorStack.pop();
        } catch (Exception e) {
            throw new FormulaValidationException();
        }
    }
}