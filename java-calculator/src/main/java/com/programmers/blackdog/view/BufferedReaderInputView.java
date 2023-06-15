package com.programmers.blackdog.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReaderInputView implements InputView {

    private final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public String read() {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException("입출력 관련 문제가 생겼습니다.");
        }
    }
}
