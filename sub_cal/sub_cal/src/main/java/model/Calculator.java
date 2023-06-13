package model;

import java.util.Stack;



public class Calculator {
    private Operator operator = new Operator();
    private Stack<Integer> s1 = new Stack<>();
    public Integer cal(String inputString) {

        // Operator 클래스로 계산식을 넘겨줍니다.
        int result = operator.operate(inputString);
        // 히스토리를 저장합니다


         return result;
    }


}
