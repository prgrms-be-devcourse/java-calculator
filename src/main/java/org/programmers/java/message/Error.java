package org.programmers.java.message;

public enum Error {
    CALCULATE_VALIDATION("잘못된 연산식이 입력되었습니다. 형식을 맞춰주세요. ex) 2 + 4 ..."),
    SELECT_VALIDATION("선택된 번호는 존재하지 않습니다. 1-3 사이의 숫자를 선택해주세요"),
    DOES_NOT_MATCH_DATA("입력한 연산식과 결과가 저장한 연산식과 결과랑 다릅니다.");

    private final String msg;

    Error(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
