package engine;

import engine.io.*;
import engine.repository.CalculatorRepository;

import java.util.List;
import java.util.Stack;

public class Calculator implements Runnable {

    private final CalculatorRepository repository;

    private final Input input;
    private final Output output;

    public Calculator(CalculatorRepository repository, Input input, Output output) {
        this.repository = repository;
        this.input = input;
        this.output = output;
    }

    @Override
    public void run() {

        while (true) {
            String inputString = input.initialInput();

            int inputValue = Integer.parseInt(inputString);

            switch (inputValue) {
                case 1:     //조회
                    List<String> formulaList = repository.findAllValues();
                    for (String f : formulaList) {
                        output.formula(f);
                    }
                    break;
                case 2:     //계산
                    String inputFormula = input.input();
                    String answer = cal(inputFormula);
                    output.output(answer);
                    save(inputFormula, answer);
                    break;
                default:
                    output.inputError();
            }
        }

    }

    public String cal(String input) {
        String formula[] = parse(input);

        /** 후위 계산식으로 변경 **/
        Stack<Double> operandStack = new Stack<>();
        Stack<String> operatorStack = new Stack<>();

        double answer = Double.valueOf(formula[0]);
        operandStack.push(answer);

        for (int i = 1; i < formula.length; i += 2) {
            String pushOper = formula[i];
            double operand = Double.valueOf(formula[i + 1]);

            if (!operatorStack.isEmpty()) {
                Operator op = Operator.getOperator(operatorStack.peek());
                int result = op.comparePriority(Operator.getOperator(pushOper));

                if (result >= 0) {   //stack pop
                    String operator = operatorStack.pop();
                    double operand2 = operandStack.pop();
                    double operand1 = operandStack.pop();

                    answer = cal(operator, operand1, operand2);
                    operandStack.push(answer);
                }
            }
            operatorStack.push(pushOper);
            operandStack.push(operand);
        }

        while (!operatorStack.isEmpty()) {
            String operator = operatorStack.pop();
            double operand2 = operandStack.pop();
            double operand1 = operandStack.pop();

            answer = cal(operator, operand1, operand2);
            operandStack.push(answer);
        }

        return String.format("%.2f", answer);
    }

    private double cal(String operator, double x, double y) {
        return Operator.getOperator(operator).calculate(x, y);
    }

    private String[] parse(String input) {
        return input.split(" ");
    }

    private void save(String formula, String answer) {
        String value = String.format
                (formula +
                        " = " +
                        answer);
        repository.save(value);
    }
}
