package com.programmers.blackdog.view;

import java.util.List;

public class PrintStreamOutputView implements OutputView {

    @Override
    public void print(int result) {
        System.out.println(result);
    }

    @Override
    public void print(List<String> list) {
        list.forEach(System.out::println);
    }

    @Override
    public void print(String string) {
        System.out.println(string);
    }
}
