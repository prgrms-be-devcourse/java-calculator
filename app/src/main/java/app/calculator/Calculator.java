package app.calculator;

import app.io.Input;
import app.io.Output;
import app.storage.MapStorage;
import app.storage.Storage;
import app.validator.InputValidator;
import app.validator.RegexConstant;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Calculator {

    private final Input input;
    private final Output output;
    private final Storage storage;
    private final PostfixMaker postfixMaker;
    private final InputValidator validator;

    public Calculator(Input input, Output output, Storage storage, PostfixMaker postfixMaker, InputValidator validator) {
        this.input = input;
        this.output = output;
        this.storage = storage;
        this.postfixMaker = postfixMaker;
        this.validator = validator;
    }

    public void run() {

        Select selectInput = Select.NONE;
        while (selectInput != Select.EXIT) {

            selectInput = input.selectInput();

            if (!validator.validateSelectInput(selectInput)) {
                output.inputError();
                continue;
            }

            if (selectInput == Select.LOOK_UP) {
                output.lookUpOutput(storage.findAll());

            } else if (selectInput == Select.CALCULATE){
                Expression expression = new Expression(input.calculateInput());

                if (!expression.validateInputExpression()) {
                    output.inputError();
                    continue;
                }

                if (storage instanceof MapStorage && ((MapStorage) storage).existExpression(expression)) {
                    output.calculateOutput(((MapStorage) storage).getExistAnswer(expression));
                    continue;
                }

                List<String> postfixExpression = postfixMaker.makePostfix(expression);
                Answer answer = calculate(postfixExpression);

                if (answer.isCorrectAnswer()) {
                    output.calculateOutput(answer);
                    storage.save(expression, answer);
                }
            } else if (selectInput == Select.EXIT) {
                output.quitProgram();
            }
        }
    }

    // 후위표기법의 연산식을 계산  -> enum + 함수형 인터페이스를 활용해서 코드를 줄여보자.
    public Answer calculate(List<String> postfixExpression) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String element : postfixExpression) {
            if (element.matches(RegexConstant.NUMBERS)) {
                stack.push(Integer.parseInt(element));
            }
            else {
                int secondOperand = stack.pop();
                int firstOperand = stack.pop();
                if (element.equals("+")) stack.push(firstOperand + secondOperand);
                else if (element.equals("-")) stack.push(firstOperand - secondOperand);
                else if (element.equals("*")) stack.push(firstOperand * secondOperand);
                else if (element.equals("/")) {
                    if (secondOperand == 0) {
                        output.divideByZeroError();
                        return Answer.createAbnormalAnswer();
                    }
                    stack.push(firstOperand / secondOperand);
                }
            }
        }

        return Answer.createCorrectAnswer(stack.pop());
    }
}
