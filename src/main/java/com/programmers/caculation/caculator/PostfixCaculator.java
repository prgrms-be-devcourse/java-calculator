package com.programmers.caculation.caculator;

import com.programmers.caculation.model.NumberAndOperator;
import com.programmers.util.Operator;
import lombok.Getter;

import java.util.Collection;
import java.util.Stack;

@Getter
public class PostfixCaculator implements Caculator {


    @Override
    public Double caculate(Collection<NumberAndOperator> operatorAndNumbersSortedByPostfix) throws Exception{
        Stack<Double> postfixStack = new Stack<>();

        for (NumberAndOperator o : operatorAndNumbersSortedByPostfix) {
            if (o.isNumber()) {
                postfixStack.push(o.getNumber());
            } else if (o.isOperator()) {
                double right = postfixStack.pop();
                double left = postfixStack.pop();
                double result = Operator.caculate(o.getOperator(), left, right);// 0 나누기 에러처리같은거 해줘야함
                postfixStack.push(result);


            }
        }
        if (postfixStack.size() == 1) {
            return postfixStack.pop();
        } else {
            throw new Exception("잘못된 입력입니다. 결과를 알 수 없습니다.");
        }
    }


}