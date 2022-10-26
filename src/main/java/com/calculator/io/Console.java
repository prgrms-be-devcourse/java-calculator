package com.calculator.io;

import java.io.IOException;

public class Console implements Input, Output{

    @Override
    public int inputType() throws IOException {
        System.out.println("1. 조회\n 2. 계산\n 3. 끝");
        System.out.println("\n 선택 : ");
        return Integer.parseInt(br.readLine());
    }

    @Override
    public String inputNum() throws IOException {
        String input = br.readLine();
        System.out.println(input);
        return input;
    }

    @Override
    public void output(int result) {
        System.out.println(result);
    }
}
