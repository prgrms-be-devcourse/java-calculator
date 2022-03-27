package com.programmers;

import com.programmers.calculator.model.CalcData;
import com.programmers.calculator.io.Input;
import com.programmers.calculator.io.Output;

import java.util.List;
import java.util.Scanner;

public class Console implements Input, Output {
    private final Scanner sc = new Scanner(System.in);

    @Override
    public int action() {
        return sc.nextInt();
    }

    @Override
    public String formula() {
        System.out.println();
        sc.nextLine();
        return sc.nextLine();
    }

    @Override
    public void select() {
        System.out.println("1. 조회");
        System.out.println("2. 계산");
        System.out.println();

        System.out.print("선택 : ");
    }

    @Override
    public void result(double i) {
        System.out.println();
        System.out.println(i);
        System.out.println();
    }

    @Override
    public void results(List<CalcData> list) {
        list.forEach((v) ->
                System.out.println(v.getCalcFormula() + " = " + v.getResult()));
        System.out.println();
    }

    @Override
    public void error(String s) {
        System.out.println();
        System.out.println("오류가 발생했습니다. (" + s + ")");
    }
}
