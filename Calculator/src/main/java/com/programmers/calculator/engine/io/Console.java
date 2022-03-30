package com.programmers.calculator.engine.io;

import com.programmers.calculator.engine.repository.CalculatorRepository;
import com.programmers.calculator.engine.repository.MemoryCalculatorRepository;

import java.util.List;
import java.util.Scanner;

public class Console implements Input, Output  {

    private final Scanner scanner = new Scanner(System.in);
    private CalculatorRepository repository = new MemoryCalculatorRepository();

    @Override
    public String optionInput()  {
        System.out.println("1. 조회");
        System.out.print("2. 계산\n\n");
        System.out.print("선택 : ");
        String str = scanner.nextLine();
        System.out.println();
        return str;
    }

    @Override
    public String calculationInput() {
        String str = scanner.nextLine();
        return str;
    }

    @Override
    public void inputError() {
        System.out.println("입력이 잘못되었습니다.\n");
    }

    @Override
    public void lookUp(List<String> list) {
        list.stream().forEach(System.out::println);
        System.out.println();
    }
}
