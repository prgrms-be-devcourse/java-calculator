package com.programmers.java.engine.io.exception;

/*
* ParsedException : 파싱할 때 발생하는 예외
* - 고민 : 어떤 이유로 파싱이 되지 않았는지까지 보여주려면 어떤 방식이 좋을까요?
* 1. ParsedException의 멤버변수 message를 지정하여 ParsedException을 new를 통해 생성 시 메시지를 유동적으로 지정
* 2. ParsedException을 상속하는 다른 public Exception 클래스 정의 / 독립적으로 클래스 정의
* */
public class ParsedException extends Exception{

    @Override
    public String toString() {
        return "입력하신 문자열이 양식에 맞지 않아 파싱할 수 없습니다.";
    }
}