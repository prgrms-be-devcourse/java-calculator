package com.programmers.java.engine;

/*
Menu : 사용자가 선택하는 메뉴
- 메뉴 옵션과 상수를 enum을 통해 한 곳에서 관리한다.
*/
enum Menu {
    EXIT("종료"),
    LOOKUP("조회"),
    CALCULATE("계산");

    private final String prompt;

    Menu(String prompt) {
        this.prompt = prompt;
    }

    @Override
    public String toString() {
        return prompt;
    }
}
