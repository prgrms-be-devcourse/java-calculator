package com.bona.javacalculator.service;

import java.util.Stack;

public class MakePostfixService {
    //후위 표기로 변환
    public String convPostfix(String input) {
        char c = ' ';
        Stack<Object> operationStack = new Stack<>(); //연산자 스택
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            c = input.charAt(i);
            if (Character.isDigit(c)) {//숫자면 표현
                sb.append(c);
            } else if (operationStack.isEmpty()) {//연산자 스택이 비어있을 경우 값 push
                operationStack.push(c);
            } else {// 연산자가 스택에 있는 경우
                if (compareOperation((char) operationStack.peek(), c) > 0) { //현재 연산자가 우선순위 더 높을 때
                    operationStack.push(c); // 연산자 저장
                } else {
                    while (!operationStack.isEmpty()) {
                        //현재 연산자가 우선순위 더 낮거나 같은 경우
                        if (compareOperation((char) operationStack.peek(), c) <= 0) {
                            sb.append(operationStack.pop()); // 스택에 있는 우선순위 높은 연산자 pop
                        } else {
                            break;
                        }
                    }
                    operationStack.push(c);
                }
            }
        }
        char check = ' ';
        while (!operationStack.isEmpty()) {
            check = (char) operationStack.pop();
            sb.append(check);
        }
        return sb.toString();
    }


    //연산자 우선순위 반환
    public static int getOperationPriority(char op) {
        switch (op) {
            case '*':
            case '/':
                return 2;
            case '+':
            case '-':
                return 1;
            default:
                throw new IllegalStateException("유효하지 않은 연산자 입니다" + op);
        }
    }

    //연산자 우선순위 비교
    public static int compareOperation(char op, char opNow) {
        int operationPriority = getOperationPriority(op);
        int operationPriorityNow = getOperationPriority(opNow);

        if (operationPriorityNow > operationPriority) {
            return 1;
        } else if (operationPriorityNow == operationPriority) {
            return 0;
        } else {
            return -1;
        }

    }

}
