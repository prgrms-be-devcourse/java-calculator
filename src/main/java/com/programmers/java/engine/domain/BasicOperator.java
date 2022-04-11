package com.programmers.java.engine.domain;

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

    BasicOperator(String operatorPattern) {
        this.symbol = operatorPattern;
    }

    @Override
    public String toString(){
        return symbol;
    }

    public static BasicOperator initFromPattern(String pattern){
        for(BasicOperator opt : values()){
            if(opt.symbol.equals(pattern)){
                return opt;
            }
        }
        throw new IllegalArgumentException("연산자가 잘못되었습니다.");
    }
}
