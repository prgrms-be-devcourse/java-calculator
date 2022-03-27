package com.programmers.cal.view;

import com.programmers.cal.logic.Formula;
import java.util.List;

public class OutPutView {

    public static void calculatorResult(double value) {
        System.out.println(value);
    }

    public static void calculatorHistory(List<Formula> formulaList) {
        formulaList.forEach(System.out::println);
    }

}
