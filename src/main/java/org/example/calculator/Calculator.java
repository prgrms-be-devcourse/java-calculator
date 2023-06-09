package org.example.calculator;

import java.util.Stack;

public class Calculator {

    // for operation enum.
    private enum Ops { PLUS, MINUS, MULT, DIV }

    // for Plus / Minus Operation.
    private static Ops PM;

    // for Multiply / Divide Operation.
    private static Ops MD;

    private static Calculator calculator = new Calculator();

    private Calculator() {}

    public static Calculator getInstance() { return calculator; }

    public int calculate(String[] command) {
        int result = 0;
        Stack<Integer> st = new Stack<>();

        // 처음의 수를 더해주기 위함.
        PM = Ops.PLUS;
        for(int i = 0; i < command.length; i++) {
            if(i % 2 == 1) {
                switch (command[i]) {
                    // + or - : flush.
                    case "+" :
                        if(PM == Ops.PLUS)
                            result += st.peek();
                        else
                            result -= st.peek();
                        st.pop();
                        // 이후 st.peek()를 더해줄지 빼줄지의 flag.
                        PM = Ops.PLUS;
                        break;
                    case "-" :
                        if(PM == Ops.PLUS)
                            result += st.peek();
                        else
                            result -= st.peek();
                        st.pop();
                        PM = Ops.MINUS;
                        break;
                    // * or / : just memoizing.
                    case "*" :
                        MD = Ops.MULT;
                        break;
                    case "/" :
                        MD = Ops.DIV;
                        break;
                }
            }

            // 정수 -> 연산해서 stack push or 그냥 push.
            else {
                int tmp = Integer.parseInt(command[i]);
                if(st.isEmpty())
                    st.push(tmp);
                else {
                    int top = st.peek();
                    st.pop();
                    if(MD == Ops.MULT)
                        st.push(top * tmp);
                    else
                        st.push(top / tmp);
                }
            }
        }

        if(PM == Ops.PLUS)
            result += st.peek();
        else
            result -= st.peek();

        return result;
    }
}
