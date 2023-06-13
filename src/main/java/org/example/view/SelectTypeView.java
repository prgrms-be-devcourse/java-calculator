package org.example.view;

import java.util.Arrays;

public enum SelectTypeView {

    GET_RECORD(1, "조회"),
    CALCULATE(2, "계산"),
    END(3,"종료");

    private final int num;
    private final String option;

    SelectTypeView(int num, String option) {
        this.num = num;
        this.option = option;
    }

    public static SelectTypeView findByNum(int num){
        return Arrays.stream(SelectTypeView.values())
                .filter(stv -> stv.num == (num))
                .findFirst()
                .orElse(null);
    }

}
