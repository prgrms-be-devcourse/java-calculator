package engine;

import engine.io.*;
import engine.repository.CalculatorRepository;

import java.util.List;
import java.util.Stack;

public class Calculator implements Runnable {

    private final CalculatorRepository repository;

    private final InputConsole inputConsole;
    private final OutputConsole outputConsole;

    public Calculator(CalculatorRepository repository, InputConsole inputConsole, OutputConsole outputConsole) {
        this.repository = repository;
        this.inputConsole = inputConsole;
        this.outputConsole = outputConsole;
    }

    @Override
    public void run() {

        while (true) {
            String inputString = inputConsole.menuInput();

            int inputValue = Integer.parseInt(inputString);

            try {
                switch (inputValue) {
                    case 1:     //조회
                        List<String> formulaList = repository.findAllValues();
                        for (String f : formulaList) {
                            outputConsole.formula(f);
                        }
                        break;
                    case 2:     //계산
                        String inputFormula = inputConsole.input();
                        String answer = cal(inputFormula);
                        outputConsole.output(answer);
                        save(inputFormula, answer);
                        break;
                    default:
                        outputConsole.inputErrorMessage();
                }
            } catch (ArithmeticException e) {
                outputConsole.arithmeticErrorMessage();
            } catch (IllegalArgumentException e) {
                outputConsole.illegalArgumentErrorMessage();
            }
        }

    }

    public String cal(String input) throws ArithmeticException, IllegalArgumentException {
        String[] formula = parse(input);

        /** 후위 계산식으로 변경 **/
        Stack<Double> operandStack = new Stack<>();
        Stack<String> operatorStack = new Stack<>();

        double answer = Double.parseDouble(formula[0]);
        operandStack.push(answer);

        for (int i = 1; i < formula.length; i += 2) {
            String pushOper = formula[i];
            double operand = Double.parseDouble(formula[i + 1]);

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

    private double cal(String operator, double x, double y) throws ArithmeticException, IllegalArgumentException {
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
