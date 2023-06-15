package org.example.view;

import org.example.domain.Calculator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class OutputView {

    public static final String MESSAGE_OPTION = "1. 조회\n2. 계산\n3. 종료\n";

    public OutputView() {
    }

    public void printOptionMessage() {
        System.out.println(MESSAGE_OPTION);
    }

    public void printCalcResult(Integer result) {
        System.out.println(result);
        System.out.println();
    }

    public void printHistory(Calculator calculator) {
        HashMap<String, Integer> map = calculator.getMap();

        Iterator<Map.Entry<String, Integer>> entry = map.entrySet().iterator();

        while (entry.hasNext()) {
            Map.Entry<String, Integer> element = entry.next();

            System.out.print(element.getKey() + " = ");
            System.out.println(element.getValue());
        }
    }
}
