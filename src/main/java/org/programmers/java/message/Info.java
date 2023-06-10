package org.programmers.java.message;

public enum Info {
    SELECT_NUM("선택 : "),
    EXIT_INFO("프로그램이 종료되었습니다");


    private final String msg;
    Info(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
