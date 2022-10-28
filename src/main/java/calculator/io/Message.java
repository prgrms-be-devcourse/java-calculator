package calculator.io;

public enum Message {
    MENU_MESSAGE("1. 조회 \n2. 계산 \n3.종료 \n선택 : "),
    ERROR_MESSAGE("입력값이 올바르지 않습니다."),
    EXIT_MESSAGE("종료되었습니다.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
