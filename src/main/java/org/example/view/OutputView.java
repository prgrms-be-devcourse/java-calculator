package org.example.view;

import java.util.List;

public class OutputView {

    public void printSelection(){
        System.out.println("1.조회");
        System.out.println("2.계산");
        System.out.println();
        System.out.print("선택 : ");
    }

    public void printResult(double result) {
        System.out.println(result);
    }

    public void printRecords(List<String> arithmeticRecords) {
        arithmeticRecords.stream().forEach(System.out::println);
    }

}
