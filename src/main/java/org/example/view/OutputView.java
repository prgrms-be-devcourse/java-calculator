package org.example.view;

import org.example.domain.Calculator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
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
        List<String> history = calculator.getHistory();

        for (int i = 0; i < history.size(); i++) {
            System.out.println(history.get(i));
        }
    }
}
