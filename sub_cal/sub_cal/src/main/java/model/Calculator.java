package model;

import java.util.Stack;
import java.util.StringTokenizer;

// 계산식을 받고 Operater 클래스로 넘겨줍니다.
// 계산 결과가 나오면 히스토리를 저장합니다.
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
