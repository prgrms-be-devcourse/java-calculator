package main.java.service;

import main.java.domain.Command;

import java.util.Stack;

public class Calculator {

    Operator PM;
    Operator MD;

    public Calculator() {}

    public int calculate(Command command) {
        PM = Operator.PLUS;
        MD = Operator.MULTIPLY;
        int result = 0;
        int[] numberArr = command.numberArr;
        Operator[] optArr = command.optArr;

        Stack<Integer> st = new Stack<>();

        // 처음의 수를 더해주기 위함.
        for(int i = 0; i < command.optCount; i++) {
            // nums
            stackPush(numberArr[i], st);

            // opts
            if(optArr[i].decideToCalculate()) {
                result = PM.calculateOpt(result, st.peek());
                PM = optArr[i];
                st.pop();
                continue;
            }
            MD = optArr[i];
        }

        stackPush(numberArr[command.optCount], st);
        // 마지막 command의 숫자까지 처리.
        result = PM.calculateOpt(result, st.peek());
        return result;
    }

    private void stackPush(int number, Stack<Integer> st) {
        if(st.isEmpty()) {
            st.push(number);
            return;
        }
        int top = st.peek();
        st.pop();
        st.push(MD.calculateOpt(top, number));
    }
}
