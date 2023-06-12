package org.programmers.java.message;

import java.util.Arrays;
import java.util.Optional;

public enum FunctionSelect {
    CHECK("1. 조회", "1"),
    CALCULATION("2. 계산", "2"),
    EXIT("3. 종료", "3"),
    WRONGINPUT("입력값 에러", "4");

    private final String msg;
    private final String selectNum;

    FunctionSelect(String msg, String selectNum) {
        this.msg = msg;
        this.selectNum = selectNum;
    }

    public String getSelectNum() {
        return selectNum;
    }

    public String getMsg() {
        return msg;
    }

    public static Optional<FunctionSelect> findSelect(String inputSelectNum){

             return Arrays.stream(FunctionSelect.values())
                .filter(function -> function.selectNum.equals(inputSelectNum))
                .findAny();
    }
}
