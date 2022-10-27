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
            output.printMenu("1. 조회\n2. 계산\n3. 종료");
            String selectedMenu = input.selectMenu("선택 : ");

            if (!validate.isValidMenu(selectedMenu)) continue;
            int menuNumber = Integer.parseInt(selectedMenu);

            if (Menu.HISTORY.getNumber() == menuNumber) {
                output.printSavedResults(repository);
            } else if (Menu.CALCULATE.getNumber() == menuNumber) {
                String expression = input.input();

                if(!validate.isValidExpression(expression)) continue;

                long answer = compute.compute(expression);

                repository.saveResult(expression,answer);

                output.printCalculatedResult(answer);
            } else if (Menu.EXIT.getNumber() == menuNumber) {
                break;
            }
        }
    }
    // test code로 확인할 부분
    // 유효한 메뉴인지 확인
    // 유효한 수식인지 확인
    // 계산
    // repository 에 저장
    // 계산 결과 출력
}
