package com.programmers.java;

import com.programmers.java.engine.domain.Operand;
import com.programmers.java.engine.domain.Operator;
import com.programmers.java.engine.operations.ArithmeticOperation;

public class OperationImpl implements ArithmeticOperation {
    @Override
    public Operand operation(Operand a, Operand b, Operator opt) {
        if (opt == Operator.PLUS){
            return new Operand(a.number + b.number);
        }
        else if(opt == Operator.MINUS){
            return new Operand(a.number - b.number);
        }
        else if(opt == Operator.MULTIPLY){
            return new Operand(a.number * b.number);
        }
        else{
            if(b.number == 0){
                throw new ArithmeticException("0으로 나누는 것은 안됩니다.");
            }
            return new Operand(a.number / b.number);
        }
    }
}
