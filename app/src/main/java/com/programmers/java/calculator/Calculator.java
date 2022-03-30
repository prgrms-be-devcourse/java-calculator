package com.programmers.java.calculator;

import com.programmers.java.calculator.engine.Input;
import com.programmers.java.calculator.engine.Output;
import com.programmers.java.calculator.model.Problem;
import lombok.AllArgsConstructor;

import java.util.EmptyStackException;
import java.util.List;
@AllArgsConstructor
public class Calculator implements Runnable{
    private Input input;
    private Output output;
    private List<Problem> problems;

    @Override
    public void run() {
        while (true){
            int option = input.selectOption();
            System.out.println();
            switch (option){
                case 2:
                    String question = input.inputProblem();
                    try {
                        Problem problem = makeProblem(question);
                        problems.add(problem);
                        output.showAnswer(problem);
                    } catch (EmptyStackException e){
                        output.inputError();
                    }
                    break;
                case 1:
                    output.showAllProblemNAnswer(problems);
                    break;
            }
        }
    }

    public Problem makeProblem(String input){
        return new Problem().makeQuestionArray(input).calculate();
    }
}
