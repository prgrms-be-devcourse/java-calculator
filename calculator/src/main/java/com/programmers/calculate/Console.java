package com.programmers.calculate;

import com.programmers.calculate.engine.model.io.Input;
import com.programmers.calculate.engine.model.io.Output;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Console implements Input, Output {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String selectNumber() {
        System.out.println("1. 조회\n2. 계산\n3. 종료");
        System.out.print("선택: ");
        return scanner.nextLine();
    }

    @Override
    public String inputExpression() {
        System.out.print("\n계산 식을 입력하세요: ");
        return scanner.nextLine();
    }

    @Override
    public void printErrorMessage() {
        System.out.println("잘못된 입력 값입니다.");
    }

    @Override
    public void printMapValues(Map<Long, String> map) {
        List<String> list = new ArrayList<>(map.values());
        list.forEach(System.out::println);
    }
}
