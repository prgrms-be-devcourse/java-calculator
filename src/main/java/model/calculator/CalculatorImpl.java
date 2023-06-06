package model.calculator;

import model.vo.MathExpression;

import java.util.ArrayList;
import java.util.Stack;

public class CalculatorImpl implements Calculator{
    @Override
    public int calculate(final MathExpression me) {
        ArrayList<String> op = me.getOp();
        ArrayList<Integer> nums = me.getNums();

        ArrayList<String> remainOp = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(nums.get(0));
        for (int i = 0; i < op.size(); ++i) {
            switch (op.get(i)) {
                case "+", "-" -> {
                    stack.push(nums.get(i + 1));
                    remainOp.add(op.get(i));
                }
                case "*" -> stack.push(stack.pop() * nums.get(i + 1));
                case "/" -> stack.push(stack.pop() / nums.get(i + 1));
            }
        }
        int sum = stack.get(0);
        for (int i = 0; i < remainOp.size(); ++i) {
            switch (remainOp.get(i)) {
                case "+" -> sum += stack.get(i + 1);
                case "-" -> sum -= stack.get(i + 1);
            }
        }
        return sum;
    }
}
