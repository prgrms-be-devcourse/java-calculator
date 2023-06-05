import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Calculator {

    // private 메소드로 계산 메소드에 넣을 예정
    public static String toPostfix(String[] infixExpression) {
        Stack<String> stack = new Stack<>();
        StringBuilder postfixExpression = new StringBuilder();

        for (String value : infixExpression) {
            // 숫자면 식에 그대로 추가
            if (isNumber(value)) {
                postfixExpression.append(value);
            }
            //연산자라면 -> 스택에 담긴 연산자와 우선순위를 비교해 순서대로 넣음
            else {
                CalculateType calculateType = CalculateType.findBySymbol(value);
                while (!postfixExpression.isEmpty() && !stack.isEmpty() &&
                        calculateType.getPriority() <= CalculateType.findBySymbol(stack.peek()).getPriority()) {
                    postfixExpression.append(stack.pop());
                }
                stack.push(value);
            }
        }
        while (!postfixExpression.isEmpty() && !stack.isEmpty()) {
            postfixExpression.append(stack.pop());
        }
        return postfixExpression.toString();
    }


    //이제 계산하는 연산 필요
    public static String calculate(String postfixExpression){

        return "1";
    }

    public static boolean isNumber(String value) {
        if (value.matches("[0-9]")) {
            return true;
        }
        return false;
    }



}
