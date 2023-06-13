package org.devcourse.calculator;

import org.devcourse.exception.MenuTypeException;
import org.devcourse.io.IODevice;
import org.devcourse.repository.Repository;
import org.devcourse.util.DigitChecker;
import org.devcourse.validator.ExpressionValidator;
import org.devcourse.validator.MenuValidator;
import org.devcourse.validator.Validator;

import java.util.List;
import java.util.Stack;

public class Calculator {

    private final IODevice ioDevice;
    private final Repository repository;

    public Calculator(IODevice ioDevice, Repository repository) {
        this.ioDevice = ioDevice;
        this.repository = repository;
    }

    public void run() {

        boolean isPowered = true;

        while (isPowered) {

            // 메뉴 입력
            ioDevice.outputMenus();
            String menuType = ioDevice.inputMenu();


            // 메뉴 입력 검증
            Validator<String> inputMenuValidator = new MenuValidator<>();
            boolean isValidMenu = inputMenuValidator.validate(menuType);
            if(!isValidMenu) continue;


            // 메뉴 입력에 따른 연산 수행
            MenuType menu = MenuType.findByMenuNum(Integer.parseInt(menuType));
            switch (menu) {

                case CALCULATE:

                    // 수식 입력 및 검증
                    String expression = ioDevice.inputExpression();

                    Validator<String> inputExpressionValidator = new ExpressionValidator<>();
                    boolean isValidExpression = inputExpressionValidator.validate(expression);
                    if(!isValidExpression) continue;

                    // 연산 위한 수식변형 (중위 표기식 String -> 중위 표기식 List 변환 -> 후위 표기식 List 변환 )
                    List<String> infixList = ExpressionConverter.expressionStrToList(expression);
                    List<String> postfix = ExpressionConverter.infixToPostfix(infixList);

                    // 연산 결과 출력
                    StringBuilder result = new StringBuilder();

                    try {
                        result.append(calculate(postfix));
                    } catch (ArithmeticException e) {
                        System.out.println(e.getMessage());
                        break;
                    }


                    // 연산 결과 저장 후 출력
                    String runHistory = ExpressionConverter.convertToResult(expression, result.toString());
                    repository.save(runHistory);
                    ioDevice.outputSingleResult(result.toString());
                    break;



                case HISTORY:
                    ioDevice.outputList(repository.findAll());
                    break;



                case EXIT:
                    ioDevice.outputSingleResult("계산기가 종료됩니다.");
                    isPowered = false;
                    break;

            }

        }

    }


    private String calculate(List<String> postfix) throws ArithmeticException {

        Stack<Double> stack = new Stack<>();

        for (String term : postfix) {

            if (DigitChecker.isDigit(term)) {

                stack.push(Double.parseDouble(term));

            } else {

                Double operand1 = stack.pop();
                Double operand2 = stack.pop();

                Double res = operation(operand2, operand1, term);
                stack.push(res);
            }
        }


        Double res = stack.pop();
        if (DigitChecker.isInteger(res)) {
            return String.valueOf(Math.round(res));

        } else {
            return String.valueOf(res);

        }
    }

    private Double operation(Double operand1, Double operand2, String operator) throws ArithmeticException {


        switch (operator) {

            case "+":
                return operand1 + operand2;

            case "*":
                return operand1 * operand2;

            case "-":
                return operand1 - operand2;

            default:


                if(operand2 == 0) {
                    throw new ArithmeticException("0으로 나눌 수 없습니다.");
                } else {
                    return operand1 / operand2;
                }





        }
    }
}

