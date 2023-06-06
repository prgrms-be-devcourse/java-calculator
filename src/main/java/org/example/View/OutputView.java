package org.example.View;

import java.util.ArrayList;

public class OutputView {

    public static void printResult(double result) {
        System.out.println(result);
    }

    public static void printRecords(ArrayList<String> arithmeticRecords) {
        for (int i = 0; i < arithmeticRecords.size(); i++) {
            System.out.println(arithmeticRecords.get(i));
        }
    }
}
