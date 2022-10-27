package com.calculator.io;

import com.calculator.common.BaseException;
import com.calculator.common.ValidatorHandler;
import lombok.AllArgsConstructor;

import java.io.IOException;

@AllArgsConstructor
public class Console implements Input, Output{

    private ValidatorHandler validatorHandler;

    @Override
    public String inputType() throws IOException {
        System.out.println("\n1. 조회\n2. 계산\n3. 끝");
        System.out.print("\n선택 : ");

        String input = br.readLine();
        System.out.println();
        return input;
    }

    @Override
    public String inputNum() throws BaseException, IOException {
        try {
            String input = br.readLine();
            validatorHandler.inputError(input);

            return input;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void output(double result) {
        System.out.println(String.valueOf(result).replaceAll(".0$", ""));
    }
}
