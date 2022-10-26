package com.calculator.io;

import java.io.IOException;

public class Console implements Input, Output{

    @Override
    public int inputType() throws IOException {
        System.out.println("\n1. 조회\n2. 계산\n3. 끝");
        System.out.print("\n선택 : ");

        String input = br.readLine();
        System.out.println();
        return Integer.parseInt(input);
    }

    @Override
    public String inputNum() throws IOException {
        String input = br.readLine();
        return input;
    }

    @Override
    public void output(double result) {
        System.out.println(String.valueOf(result).replaceAll(".0$", ""));
    }
}
