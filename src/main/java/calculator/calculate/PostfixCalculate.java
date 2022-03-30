package calculator.calculate;

import calculator.calculations.Calculations;

import java.util.ArrayList;
import java.util.Stack;

public class PostfixCalculate implements Calculate{

    @Override
    public int execute(ArrayList<String> exp) {
        Stack<Integer> operand = new Stack<>();

        for (String oper : exp) {
            try {
                Integer number = Integer.parseInt(oper);
                operand.push(number);
            } catch (NumberFormatException e) {
                Integer b = operand.pop();
                Integer a = operand.pop();

                switch (oper) {
                    case "+" -> operand.push(Calculations.add(a, b));
                    case "-" -> operand.push(Calculations.sub(a, b));
                    case "*" -> operand.push(Calculations.mul(a, b));
                    case "/" -> operand.push(Calculations.div(a, b));
                    default -> {  } // error
                }

            }
        }
        return operand.pop();
    }
}
