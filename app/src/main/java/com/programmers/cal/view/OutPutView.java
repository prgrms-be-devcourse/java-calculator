package com.programmers.cal.view;

import com.programmers.cal.logic.Formula;
import java.util.List;

public class OutPutView {

    public static void showsTheMenu() {
        System.out.println(OutputMessage.READY.getMessage());
    }

    public static void showsTheCalculationResult(double value) {
        System.out.println(value);
    }

    public static void showsTheCalculationHistory(List<Formula> formulaList) {
        formulaList.forEach(System.out::println);
    }

}
