package org.example.Output;

import java.util.List;

public class ShowingText implements Show {
    @Override
    public void showMenu() {
        System.out.println("1. 조회\n2. 계산\n3. 종료\n");
        System.out.print("선택 : ");
    }

    @Override
    public void showRecords(List<String> records) {
        records.forEach(System.out::println);
    }

    @Override
    public void showResult(int result) {
        System.out.println(result);
    }

    @Override
    public void lineBreak() {
        System.out.println();
    }

    @Override
    public void showInvalidInput() {
        System.out.println("잘못된 값을 입력하였습니다.");
    }
}
