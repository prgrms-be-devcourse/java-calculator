package io;

import calculation.Calculator;
import calculation.Converter;
import repository.Repository;
import validation.Validator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EmptyStackException;

public class Console {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final Repository repository;

    public Console(Repository repository) {
        this.repository = repository;
    }

    public void run() throws IOException {
        while (true) {
            System.out.println(DisplayMessage.SELECT.getMessage());
            System.out.println(DisplayMessage.CALCULATION.getMessage());
            System.out.println(DisplayMessage.EXIT.getMessage());
            System.out.print(DisplayMessage.CHOOSE.getMessage());

            String getChoice = br.readLine();
            if (Validator.isNotNumber(getChoice)) {
                System.out.println(DisplayMessage.BAD_REQUEST.getMessage());
                continue;
            }

            int choice = Integer.parseInt(getChoice);
            if (choice == 1) {
                // 조회
                repository.inquiry();
            } else if (choice == 2) {
                // 계산
                String getInput = Converter.removeWhiteSpace(br.readLine());

                if (!Validator.isRightExpr(getInput)) {
                    System.out.println(DisplayMessage.WRONG_EXPR.getMessage());
                    continue;
                }

                try {
                    Calculator calculator = new Calculator(getInput);
                    int result = calculator.calculate();
                    repository.save(getInput);

                    System.out.print(DisplayMessage.OUTPUT.getMessage());
                    System.out.println(result);
                } catch (EmptyStackException | ArithmeticException e) {
                    System.out.println(DisplayMessage.WRONG_EXPR.getMessage());
                }
            } else if (choice == 3) {
                // 종료
                System.exit(0);
            } else {
                System.out.println(DisplayMessage.BAD_REQUEST.getMessage());
            }
        }
    }
}
