package calculator;

import calculator.io.ExpressionConverter;
import calculator.model.Operation;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

import static calculator.global.InputConstants.OPERAND_REGEX;
import static calculator.global.InputConstants.OPERATOR_REGEX;

@ToString
public class InfixToPostfixConverter implements ExpressionConverter {
    private ArrayList<String> infix;
    private static final ArrayList<String> postfix = new ArrayList<>();
    private static final Stack<String> opStack = new Stack<>();

    @Override
    public ArrayList<String> convert(String infixExpression) {
        StringBuilder num = new StringBuilder();
        Operation operation = new Operation();

        // 중위 표기식을 리스트로 변환
        infix = new ArrayList<>(Arrays.asList(infixExpression.split(" ")));

        // 후위 표기식으로 전환
        for(String s : infix){
            if(s.matches(OPERATOR_REGEX)){
                if(!num.toString().equals("")){
                    postfix.add(num.toString());
                    num = new StringBuilder();
                }
                if (opStack.isEmpty()) opStack.push(s);
                else {
                    if (Operation.getOperator(opStack.peek()).isSameOrGrater(Operation.getOperator(s))) {
                        postfix.add(opStack.pop());
                    }
                    opStack.push(s);
                }
            } else if (s.matches(OPERAND_REGEX)) {
                num.append(s);
            }
        }
        if(!num.toString().equals("")){
            postfix.add(num.toString());
        }
        while(!opStack.isEmpty()){
            postfix.add(opStack.pop());
        }
        return postfix;
    }
}
