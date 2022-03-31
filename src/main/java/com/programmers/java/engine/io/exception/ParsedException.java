package com.programmers.java.engine.io.exception;

public class ParsedException extends Exception{

    @Override
    public String toString() {
        return "입력하신 문자열이 양식에 맞지 않아 파싱할 수 없습니다.";
    }
}