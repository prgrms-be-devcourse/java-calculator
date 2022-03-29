package util;

import lombok.Getter;

@Getter
public enum GuideMessage {

    INPUT_MENU("메뉴를 선택하세요\n1. 조회\n2. 계산\n3. 종료\n선택:"),
    INPUT_EXPRESSION("계산 식을 입력하세요:"),
    OUTPUT_RESULT("계산 결과:"),
    OUTPUT_EMPTY("계산기 DB가 비어 있습니다. 계산 해주세요.");
    private final String message;

    GuideMessage(String message) {
        this.message = message;
    }

}
