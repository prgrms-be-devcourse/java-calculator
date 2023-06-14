package org.example.Output;

import java.util.List;

public class ShowText implements Show{
    @Override
    public void showMenu() {
        System.out.println("1. 조회\n2. 계산\n");
        System.out.print("선택 : ");
    }

    @Override
    public void showRecords(List<String> records) {
        records.forEach(System.out::println);
    }
}
