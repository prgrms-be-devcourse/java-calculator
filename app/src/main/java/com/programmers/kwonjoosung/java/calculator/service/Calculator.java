package com.programmers.kwonjoosung.java.calculator.service;

// 인터페이스를 사용한 이유는 나중에 더 다양한 기능을 하는 계산기로 바꾸기 위해서
public interface Calculator {
    String calculate(String[] expression);
}
