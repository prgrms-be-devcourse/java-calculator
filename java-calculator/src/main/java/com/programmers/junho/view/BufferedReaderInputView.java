package com.programmers.junho.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReaderInputView implements InputView {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public int getSelectedCode() {
        try {
            System.out.print("선택 : ");
            return Integer.parseInt(bufferedReader.readLine());
        } catch (IOException | NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        }
    }

    @Override
    public String getExpression() {
        try {
            System.out.print("식 : ");
            return bufferedReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
