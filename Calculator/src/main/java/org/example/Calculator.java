package org.example;

import org.example.compute.Compute;
import org.example.io.Input;
import org.example.io.Output;
import org.example.repository.Repository;
import org.example.validate.Validate;

import java.io.IOException;

public class Calculator {
    private Input input;
    private Output output;
    private Validate validate;
    private Compute compute;
    private Repository repository;


    public Calculator(Input input, Output output, Validate validate, Compute compute, Repository repository) {
        this.input = input;
        this.output = output;
        this.validate = validate;
        this.compute = compute;
        this.repository = repository;
    }

    public void calculate() throws IOException {
        while (true) {
            output.printMenu("1. 조회\n2. 계산");
            int menuNumber = input.selectMenu("선택 : ");

            if (Menu.HISTORY.getNumber() == menuNumber) {
                output.printSavedResults(repository);
            } else if (Menu.CALCULATE.getNumber() == menuNumber) {
                String expression = input.input();
                // 유효한 입력인지 확인
                if(!validate.isValidExpression(expression)) continue;
                // 계산
                long answer = compute.compute(expression);
                // repository 에 저장
                repository.saveResult(expression,answer);
                // 계산 결과 출력
                output.printCalculatedResult(answer);
            }
        }
    }

}
