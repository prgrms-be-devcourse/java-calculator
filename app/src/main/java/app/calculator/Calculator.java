package app.calculator;

import app.io.Input;
import app.io.Output;
import app.storage.Storage;
import app.validator.InputValidator;

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
                String expression = input.calculateInput();

                if (!validator.validateCalculateInputValue(expression)) {
                    output.inputError();
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

    // 후위표기법의 연산식을 계산
    public Answer calculate(List<String> postfixExpression) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String element : postfixExpression) {
            if (element.matches("\\d+")) stack.push(Integer.parseInt(element));
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
