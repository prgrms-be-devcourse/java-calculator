package org.programmers.java.console;

import java.util.Map;

public interface Output {
    void menuMsg();
    void errorMsg(String msg);
    void selectMsg(String selectNum);
    void calculationValue(String value);
    void getCalculationValues(Map<Long,String> Values);
    void exitMsg();
}
