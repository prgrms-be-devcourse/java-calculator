package com.programmers.engine.caculator;

import com.programmers.engine.model.CaculatorParseData;
import com.programmers.util.Operator;
import lombok.Getter;

import java.text.DecimalFormat;
import java.util.Collection;
import java.util.Stack;

@Getter
public class PostfixCaculator implements Caculator {

    private Double result;
    public String getResult() throws Exception{
        if(this.result == null){
            throw new Exception("계산결과가 잘못됐습니다. 계산식을 다시 확인해 주세요");
        }
        DecimalFormat formatter = new DecimalFormat("0.##");
//        String result = String.format("%.2f", this.result);
//        return result;
        return formatter.format(this.result);

    }


    @Override
    public void caculate(CaculatorParseData operatorAndNumbersSortedByPostfix) {
        Stack<Double> postfixStack = new Stack<>();
        Collection<?> allList = operatorAndNumbersSortedByPostfix.getAllList();
        for (Object o : allList) {
            if (o instanceof Double) {
                postfixStack.push((Double) o);
            } else if (o instanceof Character) {
                double right = postfixStack.pop();
                double left = postfixStack.pop();
                try{
                    double result = Operator.caculate((Character) o, left, right);// 0 나누기 에러처리같은거 해줘야함
                    postfixStack.push(result);
                }catch (ArithmeticException e){
                    this.result = null;
                    return ;
                }

            }
        }
        if(postfixStack.size()==1){
            this.result = postfixStack.pop();
        }else {
            this.result = null;
        }
    }


}