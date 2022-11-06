package app.calculator;

import app.io.Input;
import app.io.Output;
import app.storage.Storage;
import app.validator.InputValidator;
import app.validator.RegexConstant;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

import static app.calculator.Select.*;

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
        while (selectInput != EXIT) {
            try {
                selectInput = input.selectInput();
                validator.validateSelectInput(selectInput);

                switch (selectInput) {
                    case LOOK_UP:
                        output.lookUpOutput(storage.findAll());
                        break;
                    case CALCULATE:
                        Expression expression = new Expression(input.calculateInput());
                        storage.checkStorageAndFindAnswer(storage, expression)
                                .ifPresentOrElse(output::calculateOutput, () -> {
                                    List<String> postfixExpression = postfixMaker.makePostfix(expression);
                                    Answer answer = calculate(postfixExpression);
                                    output.calculateOutput(answer);
                                    storage.save(expression, answer);
                                });
                        break;
                    case EXIT:
                        output.quitProgram();
                        break;
                }
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
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
                stack.push(Operator.calculate(element, firstOperand, secondOperand));
            }
        }

        return Answer.createCorrectAnswer(stack.pop());
    }
}
