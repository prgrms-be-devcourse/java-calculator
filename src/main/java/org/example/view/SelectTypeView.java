package org.example.view;

import java.util.Arrays;
import java.util.Optional;

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

    public static Optional<SelectTypeView> findByNum(int selectTypeNum){
        return Arrays.stream(values())
                .filter(stv -> stv.num == selectTypeNum)
                .findFirst();
    }

    public int getNum() {
        return num;
    }

    public String getOption() {
        return option;
    }
}
