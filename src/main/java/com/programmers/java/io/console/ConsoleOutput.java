package com.programmers.java.io.console;

import com.programmers.java.io.Output;

public class ConsoleOutput implements Output {
    @Override
    public void putResult(String s) {
        System.out.println(s);
    }

    @Override
    public void putError(String e) {
        System.out.println(e);
    }

    @Override
    public void putAnswer(Double d) {
        if (d == d.intValue()) System.out.println(d.intValue());
        else System.out.println(d);
    }

    @Override
    public void putEnd() {
        System.out.println("프로그램이 종료되었습니다.");
    }
}
