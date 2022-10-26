package app.calculator;

import app.io.Input;
import app.io.Output;
import app.storage.Storage;
import app.validator.InputValidator;

import java.util.List;
import java.util.Stack;

public class Calculator {

    private Input input;
    private Output output;
    private Storage storage;
    private PostfixMaker postfixMaker;
    private InputValidator validator;

    public Calculator(Input input, Output output, Storage storage, PostfixMaker postfixMaker, InputValidator validator) {
        this.input = input;
        this.output = output;
        this.storage = storage;
        this.postfixMaker = postfixMaker;
        this.validator = validator;
    }

    public void run() {

        while (true) {

            Select selectInput = input.selectInput();

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

            } else {
                break;
            }
        }
    }

    // 후위표기법의 연산식을 계산
    public Answer calculate(List<String> postfixExpression) {
        Stack<Integer> stack = new Stack<>();
        for (String element : postfixExpression) {
            if (element.matches("\\d+")) stack.push(Integer.parseInt(element));
            else {
                int secondOperand = stack.pop();
                int firstOperand = stack.pop();
                if (element.equals("+")) stack.push(firstOperand + secondOperand);
                else if (element.equals("-")) stack.push(firstOperand - secondOperand);
                else if (element.equals("*")) stack.push(firstOperand * secondOperand);
                else if (element.equals("/")) {
                    if (firstOperand == 0 || secondOperand == 0) {
                        output.calculateError();
                        return Answer.createAbnormalAnswer();
                    }
                    stack.push(firstOperand / secondOperand);
                }
            }
        }

        return Answer.createCorrectAnswer(stack.pop());
    }
}
