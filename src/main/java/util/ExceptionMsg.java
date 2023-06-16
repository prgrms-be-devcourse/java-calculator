package util;

public enum ExceptionMsg {
    NotMenuFormatException("메뉴 형식이 아닙니다."),
    NotEquationFormatException("계산식 입력 형식이 아닙니다."),
    NotSolveEquationException("방정식을 풀 수 없습니다."),
    NotSaveException("DB 저장 실패");

    private final String msg;

    ExceptionMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
