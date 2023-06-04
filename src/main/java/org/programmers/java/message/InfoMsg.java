package org.programmers.java.message;

public enum InfoMsg {
    SELECT_MESSGAE("1. 조회"),
    CALCULATION_MESSAGE("2. 계산"),
    EXIT_MESSAGE("3. 종료"),
    SELECT_NUM_MESSAGE("선택 : "),
    EXIT_INFO_MESSAGE("프로그램이 종료되었습니다");


    private final String infoMsg;
    InfoMsg(String infoMsg) {
        this.infoMsg = infoMsg;
    }

    public String getInfoMsg() {
        return infoMsg;
    }
}
