package calculator.io;

import lombok.AllArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Message {
    INPUT_MESSAGE("1. 조회 \n2. 계산 \nq. 프로그램 종료 \n\n선택 : "),
    WRONG_INPUT_ERROR_MESSAGE("잘못된 입력입니다. 다시 입력해 주세요.\n"),
    EXIT_MESSAGE("계산기 프로그램을 종료합니다.\n"),
    EMPTY_MESSAGE("계산 기록이 없습니다.\n"),
    CALCULATE_ERROR_MESSAGE("계산 할 수 없습니다.\n");



    private final String message;
}
