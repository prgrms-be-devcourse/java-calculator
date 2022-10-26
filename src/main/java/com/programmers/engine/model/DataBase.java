package com.programmers.engine.model;

import java.util.LinkedList;

public class DataBase {
    private final LinkedList<String> data = new LinkedList<>();
    public void showAll() {
        if (data.isEmpty()) System.out.println("저장된 데이터가 없습니다");
        else                data.forEach(System.out::println);
    }
    public void addData(String s){data.add(s);}
}
