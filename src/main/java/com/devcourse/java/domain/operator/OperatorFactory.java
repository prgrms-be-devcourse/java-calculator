package com.devcourse.java.domain.operator;

import com.devcourse.java.common.Factory;

public class OperatorFactory implements Factory<Operator, String> {
    public OperatorFactory() { }

    @Override
    public Operator create(String symbol) {
        switch (symbol) { // todo: 컴파일 시점에 결정되는 값만 사용가능. 다른 방법 고민하기
            case "+":
                return Plus.getInstance();
            case "-":
                return Minus.getInstance();
            case "*":
                return Multiply.getInstance();
            default:
                return Divide.getInstance();
        }
    }
}
