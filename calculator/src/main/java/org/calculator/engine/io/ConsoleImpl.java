package org.calculator.engine.io;

import lombok.RequiredArgsConstructor;
import org.calculator.engine.domain.Condition;
import org.calculator.repository.CalculateRepository;

import java.util.Scanner;

@RequiredArgsConstructor
public class ConsoleImpl implements Console {
    private Scanner scanner = new Scanner(System.in);
    private final CalculateRepository calculateRepository;

    @Override
    public void printAnswer(double answer) {
        System.out.println();
        System.out.println("result = " + answer);
        System.out.println();
    }


    @Override
    public void printHistory() {
        System.out.println();
        System.out.println("<< History Of Calculation >>");
        calculateRepository.getHistory()
                .forEach(h -> System.out.println("Equation : " + h.getEquation() + " | result : " + h.getResult()));
        System.out.println();
    }

    @Override
    public Condition getCondition() {
        System.out.println("1. 조회");
        System.out.println("2. 계산");
        System.out.println("3. 종료");
        System.out.println();
        System.out.print("선택 : ");
        return validateInput();
    }

    private Condition validateInput() {
        String condition = scanner.nextLine();
        return Condition.convert(condition).orElseThrow(() -> new IllegalArgumentException("잘못된 값을 입력하셨습니다."));
    }

    @Override
    public String insertEquation() {
        System.out.println();
        System.out.print("방정식을 입력해 주세요 : ");
        return scanner.nextLine();
    }
}
