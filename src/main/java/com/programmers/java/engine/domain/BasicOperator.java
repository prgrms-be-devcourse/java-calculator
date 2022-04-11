package com.programmers.java.engine.domain;

import java.util.HashMap;
import java.util.Map;

public enum BasicOperator implements Operator {
    PLUS("+"){
        public Operand apply(Operand x, Operand y) { return new Operand(x.number + y.number);}
    },
    MINUS("-"){
        public Operand apply(Operand x, Operand y) { return new Operand(x.number - y.number);}
    },
    DIVIDE("/"){
        public Operand apply(Operand x, Operand y) {
            if(y.number == 0){
                throw new ArithmeticException("0으로 나누는 것은 안됩니다.");
            }
            return new Operand(x.number / y.number);
        }
    },
    MULTIPLY("*"){
        public Operand apply(Operand x, Operand y) { return new Operand(x.number * y.number);}
    };

    private final String symbol;
    private static final Map<String, BasicOperator> BY_PATTERN = new HashMap<>();

    static {
        for (BasicOperator b : values()){
            BY_PATTERN.put(b.symbol, b);
        }
    }

    BasicOperator(String operatorPattern) {
        this.symbol = operatorPattern;
    }

    @Override
    public String toString(){
        return symbol;
    }

    public static BasicOperator initFromPattern(String pattern){
        if(!BY_PATTERN.containsKey(pattern)){
            throw new IllegalArgumentException("지원하지 않는 연산자 입니다.");
        }
        return BY_PATTERN.get(pattern);
    }
}
